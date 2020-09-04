package socialDiagnosticaWebPortal.config.handlers;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import socialDiagnosticaWebPortal.exceptions.UserAuthException;
import socialDiagnosticaWebPortal.persistence.entites.Role;
import socialDiagnosticaWebPortal.persistence.entites.User;
import socialDiagnosticaWebPortal.services.authServices.interfaces.UserService;
import socialDiagnosticaWebPortal.services.restServices.SocialDiagnosticaService;
import socialDiagnosticaWebPortal.utils.session.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private static final String USER_ROLE = "ROLE_USER";
	private static final String SPEC_ROLE = "ROLE_SPECIALIST";
	private static final String ADMIN_ROLE = "ROLE_ADMIN";

	@Autowired
	private UserService userService;
	@Autowired
	private SocialDiagnosticaService socialDiagnosticaService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String userName = authentication.getName();

		User user = userService.findByUserName(userName);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		try {
			session.setAttribute(SessionUtils.TOKEN, socialDiagnosticaService.authenticate(user));
		} catch (UserAuthException e) {
			log.error("Ошибка аунтификанции в сервисе диагностики", e);
		}

		//пока по дефолту берем первую роль
		Role role = user.getRoles().get(0);
		String roleName = role.getName();

		if (roleName.equalsIgnoreCase(ADMIN_ROLE)) {
			response.sendRedirect(request.getContextPath() + "/admin/");
		} else {
			response.sendRedirect(request.getContextPath() + "/workplace/");
		}
	}
}
