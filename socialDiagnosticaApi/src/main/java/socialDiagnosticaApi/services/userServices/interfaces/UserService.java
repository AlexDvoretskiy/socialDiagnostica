package socialDiagnosticaApi.services.userServices.interfaces;


import org.springframework.security.core.userdetails.UserDetailsService;

import socialDiagnosticaApi.persistence.dto.UserDto;
import socialDiagnosticaApi.persistence.entities.data.User;
import socialDiagnosticaApi.persistence.entities.rest.SystemUser;

public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	User getCurrentUser();

	User findByLoginAndPassword(String login, String password);

	void create(SystemUser systemUser);

	void create(UserDto userDto);
}
