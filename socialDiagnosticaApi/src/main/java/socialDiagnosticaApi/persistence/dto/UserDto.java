package socialDiagnosticaApi.persistence.dto;


import lombok.Data;

import java.util.List;


@Data
public class UserDto {
	private String name;
	private String fullName;
	private String password;
	private String email;
	private String appToken;
	private List<String> roles;
}
