package fr.norsys.fondation.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import fr.norsys.fondation.services.CollaborateurService;

@Configuration
@Service("customUserDetailsService")
@Qualifier
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	public CollaborateurService collaborateurService;
	public fr.norsys.fondation.entities.Collaborateur user;

	public CustomUserDetailsService() {
	}

	@Override
	public UserDetails loadUserByUsername(String email) {

		this.user = this.collaborateurService.findCollaborateurByEmail(email);
		List<GrantedAuthority> authorities = this.buildUserAuthority(this.user,
				Arrays.asList(this.user.getClass().getSimpleName()));
		return this.buildUserForAuthentication(this.user, authorities);
	}

	// Création de USER_Details apartir de l'user qu'on a dans la BD
	private User buildUserForAuthentication(fr.norsys.fondation.entities.Collaborateur user,
			List<GrantedAuthority> authorities) {

		return new User(user.getEmail(), user.getPassword(), authorities);
	}

	// Recupération des Roles de l'utilisateur
	private List<GrantedAuthority> buildUserAuthority(fr.norsys.fondation.entities.Collaborateur user,
			Collection<String> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (String userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole));
		}
		if (setAuths.isEmpty()) {
			setAuths.add(new SimpleGrantedAuthority(user.getClass().getSimpleName()));
		}

		return new ArrayList<GrantedAuthority>(setAuths);
	}

}