package socialDiagnosticaWebPortal.config.handlers;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import socialDiagnosticaWebPortal.persistence.entites.Role;
import socialDiagnosticaWebPortal.persistence.entites.User;
import socialDiagnosticaWebPortal.services.authServices.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private final String USER_ROLE = "ROLE_USER";
	private final String SPEC_ROLE = "ROLE_SPECIALIST";
	private final String ADMIN_ROLE = "ROLE_ADMIN";

	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String userName = authentication.getName();

		User user = userService.findByUserName(userName);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		//пока по дефолту берем первую роль
		Role role = user.getRoles().get(0);
		String roleName = role.getName();

		if (roleName.equalsIgnoreCase(USER_ROLE)) {
			response.sendRedirect(request.getContextPath() + "/userWorkplace/");
		} else if (roleName.equalsIgnoreCase(SPEC_ROLE)) {
			response.sendRedirect(request.getContextPath() + "/specWorkplace/");
		} else if (roleName.equalsIgnoreCase(ADMIN_ROLE)) {
			response.sendRedirect(request.getContextPath() + "/admin/");
		} else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}
}
