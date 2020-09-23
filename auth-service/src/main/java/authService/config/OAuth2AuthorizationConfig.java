package authService.config;


import authService.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;


@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	private DataSource dataSource;

	@Value("${auth.properties.web-portal}")
	private String webPortalPassword;
	@Value("${auth.properties.mobile-app}")
	private String mobileAppPassword;
	@Value("${auth.properties.social-diagnostica-service}")
	private String diagnosticaServicePassword;

	@Value("${spring.jwt.key}")
	private String tokenKey;


	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//IN-memory authentication configuration
        clients.inMemory()
				.withClient("web-portal")
					.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
					.scopes("read", "write")
					.autoApprove(true)
					.secret(passwordEncoder.encode(webPortalPassword))
				.and()
                .withClient("mobile-app")
                	.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                	.scopes("read", "write")
                	.autoApprove(true)
                	.secret(passwordEncoder.encode(mobileAppPassword))
				.and()
				.withClient("social-diagnostica-service")
					.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
					.scopes("read", "write")
					.autoApprove(true)
					.secret(passwordEncoder.encode(diagnosticaServicePassword));


//		clients.jdbc(dataSource);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints){
		endpoints
				.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
				.authenticationManager(authenticationManager)
				.accessTokenConverter(accessTokenConverter())
				.userDetailsService(userService)
				.tokenStore(tokenStore());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer){
		oauthServer
				.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()")
				.passwordEncoder(passwordEncoder)
				.allowFormAuthenticationForClients();
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(tokenKey);
		return converter;
	}
}
