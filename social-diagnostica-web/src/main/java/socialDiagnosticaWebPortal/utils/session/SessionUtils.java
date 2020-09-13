package socialDiagnosticaWebPortal.utils.session;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import socialDiagnosticaWebPortal.persistence.entites.User;

import javax.servlet.http.HttpSession;


public class SessionUtils {
	public static final String TOKEN = "token";

	public static User getCurrentUser() {
		HttpSession httpSession = getCurrentHttpSession();

		Object userObject = httpSession.getAttribute("user");
		if (userObject == null) {
			return null;
		}

		User user = (User) userObject;
		return user;
	}

	public static HttpSession getCurrentHttpSession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(false);
	}

	public static String getToken() {
		return (String) getCurrentHttpSession().getAttribute(SessionUtils.TOKEN);
	}
}
