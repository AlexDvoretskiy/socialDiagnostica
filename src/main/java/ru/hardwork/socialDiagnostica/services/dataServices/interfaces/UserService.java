package ru.hardwork.socialDiagnostica.services.dataServices.interfaces;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.hardwork.socialDiagnostica.persistence.dto.UserDto;
import ru.hardwork.socialDiagnostica.persistence.entities.SystemUser;
import ru.hardwork.socialDiagnostica.persistence.entities.data.User;


public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	User getCurrentUser();

	void create(SystemUser systemUser);

	void create(UserDto userDto);
}
