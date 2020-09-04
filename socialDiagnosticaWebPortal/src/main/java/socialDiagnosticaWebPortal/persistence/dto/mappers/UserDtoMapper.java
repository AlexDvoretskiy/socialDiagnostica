package socialDiagnosticaWebPortal.persistence.dto.mappers;


import org.springframework.stereotype.Service;
import socialDiagnosticaWebPortal.persistence.SystemUser;
import socialDiagnosticaWebPortal.persistence.dto.UserDto;


@Service
public class UserDtoMapper {

	public UserDto map(SystemUser systemUser) {
		return UserDto.builder()
				.userName(systemUser.getUserName())
				.fullName(systemUser.getFullName())
				.email(systemUser.getEmail())
				.password(systemUser.getPassword())
		.build();
	}
}
