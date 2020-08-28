package socialDiagnosticaApi.controllers;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import socialDiagnosticaApi.persistence.entities.data.User;
import socialDiagnosticaApi.persistence.entities.rest.AuthRequest;
import socialDiagnosticaApi.persistence.entities.rest.AuthResponse;
import socialDiagnosticaApi.persistence.entities.rest.SystemUser;
import socialDiagnosticaApi.services.userServices.TokenGenerateService;
import socialDiagnosticaApi.services.userServices.interfaces.UserService;

import javax.validation.Valid;


@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthRestController {
	private final UserService userService;
	private final TokenGenerateService tokenGenerateService;

	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid SystemUser systemUser) {
		userService.create(systemUser);
		return "OK";
	}

	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request) {
		User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
		String token = tokenGenerateService.generateToken(user.getName());
		return new AuthResponse(token);
	}
}
