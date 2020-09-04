package socialDiagnosticaApi.persistence.entities.system;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SystemUser {
	private String userName;
	private String fullName;
	private String email;
	private String password;
}
