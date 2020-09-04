package socialDiagnosticaWebPortal.services.authServices.interfaces;


import org.springframework.security.core.userdetails.UserDetailsService;
import socialDiagnosticaWebPortal.persistence.SystemUser;
import socialDiagnosticaWebPortal.persistence.entites.User;


public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	User getCurrentUser();

	User create(SystemUser systemUser);
}
