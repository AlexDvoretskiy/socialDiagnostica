package socialDiagnosticaApi.controllers;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import socialDiagnosticaApi.persistence.entities.data.User;
import socialDiagnosticaApi.persistence.pojo.AuthRequest;
import socialDiagnosticaApi.persistence.pojo.AuthResponse;
import socialDiagnosticaApi.persistence.entities.system.SystemUser;
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
		User existingUser = userService.findByUserName(systemUser.getUserName());
		if (existingUser != null) {
			return HttpStatus.BAD_REQUEST.getReasonPhrase();
		}
		userService.create(systemUser);
		return HttpStatus.CREATED.getReasonPhrase();
	}

	@PostMapping("/auth")
	public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest request) {
		User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
		String token = tokenGenerateService.generateToken(user.getName());

		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(new AuthResponse(token));
	}
}
