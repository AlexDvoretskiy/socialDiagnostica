package authService.services.interfaces;


import authService.persistence.dto.UserDto;
import authService.persistence.entites.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

	User findByUserName(String userName);

	User create(UserDto userDto);
}
