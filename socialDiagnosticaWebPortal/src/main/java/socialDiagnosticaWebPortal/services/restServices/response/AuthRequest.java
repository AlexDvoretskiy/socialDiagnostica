package socialDiagnosticaWebPortal.services.restServices.response;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AuthRequest {
	private String login;
	private String password;
}