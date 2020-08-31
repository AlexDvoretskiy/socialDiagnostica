package socialDiagnosticaWebPortal.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import socialDiagnosticaWebPortal.config.handlers.UserAuthenticationSuccessHandler;
import socialDiagnosticaWebPortal.services.authServices.interfaces.UserService;

import javax.sql.DataSource;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserService userService;
	@Autowired
	private UserAuthenticationSuccessHandler userAuthenticationSuccessHandler;
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/userWorkplace/**").hasRole("USER")
				.antMatchers("/specWorkplace/**").hasRole("SPECIALIST")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
					.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/auth")
					.successHandler(userAuthenticationSuccessHandler)
					.permitAll()
				.and()
					.logout()
					.permitAll()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/")
					.deleteCookies("JSESSIONID");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
}