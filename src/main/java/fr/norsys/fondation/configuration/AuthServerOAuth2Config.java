package fr.norsys.fondation.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
@Order(1)
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	@Qualifier("memoryToken")
	TokenStore tokenStore;

	@Autowired
	private CorsFilter corsFilter;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.addTokenEndpointAuthenticationFilter(this.corsFilter);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("sampleClientId").authorizedGrantTypes("implicit").scopes("read")
				.autoApprove(true).and().withClient("clientIdPassword").secret("secret")
				.authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("read");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(this.tokenStore).authenticationManager(this.authenticationManager);
	}

}
