package fr.norsys.fondation.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private CorsFilter corsFilter;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(this.tokenStore());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(this.corsFilter, ChannelProcessingFilter.class);
		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
				.antMatchers("/collaborateur/**").access("hasAnyRole('Collaborateur','Responsable','Administrateur')")
				.antMatchers("/responsable/**").access("hasAnyRole('Responsable','Administrateur')")
				.antMatchers("/administrateur/**").access("hasRole('Administrateur')").and().csrf().disable();
	}

	@Bean(name = "memoryToken")
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
}
