package socialDiagnosticaApi.config.filter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import socialDiagnosticaApi.services.userServices.TokenGenerateService;
import socialDiagnosticaApi.services.userServices.interfaces.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import static io.jsonwebtoken.lang.Strings.hasText;


@Slf4j
@Component
public class AuthFilter extends GenericFilterBean {
	private static final String AUTHORIZATION = "Authorization";
	private static final String BEARER = "Bearer ";

	@Autowired
	private TokenGenerateService tokenGenerateService;
	@Autowired
	private UserService userService;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		String token = getTokenFromRequest((HttpServletRequest) servletRequest);

		if (token != null && tokenGenerateService.validateToken(token)) {
			String userLogin = tokenGenerateService.getLoginFromToken(token);
			UserDetails userDetails = userService.loadUserByUsername(userLogin);

			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		String bearer = request.getHeader(AUTHORIZATION);
		if (hasText(bearer) && bearer.startsWith(BEARER)) {
			return bearer.substring(7);
		}
		return null;
	}
}
