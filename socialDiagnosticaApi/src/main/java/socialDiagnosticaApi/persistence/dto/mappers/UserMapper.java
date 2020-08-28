package socialDiagnosticaApi.persistence.dto.mappers;


import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import socialDiagnosticaApi.persistence.dto.UserDto;
import socialDiagnosticaApi.persistence.entities.data.Role;
import socialDiagnosticaApi.persistence.entities.data.User;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class UserMapper {

	public User mapUser(UserDto userDto) {
		List<Role> userRoles = new ArrayList<>();
		List<String> roles = userDto.getRoles();

		if (CollectionUtils.isEmpty(roles)) {
			log.error("Не заполнен список ролей для пользователя {}", userDto.getName());
		} else {
			for (String role : roles) {
				//TODO: проверка на наличие в таблице ролей
				Role userRole = new Role(role);
				userRoles.add(userRole);
			}
		}

		return User.builder()
				.name(userDto.getName())
				.fullName(userDto.getFullName())
				.password(userDto.getPassword())
				.email(userDto.getEmail())
				.appToken(userDto.getAppToken())
				.roles(userRoles)
		.build();
	}
}
