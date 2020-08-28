package ru.hardwork.socialDiagnostica.controllers.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.hardwork.socialDiagnostica.persistence.entities.rest.AuthRequest;
import ru.hardwork.socialDiagnostica.persistence.entities.rest.AuthResponse;
import ru.hardwork.socialDiagnostica.persistence.entities.rest.SystemUser;
import ru.hardwork.socialDiagnostica.services.userServices.TokenGenerateService;
import ru.hardwork.socialDiagnostica.services.userServices.interfaces.UserService;

import javax.validation.Valid;


@Slf4j
@RestController
public class AuthRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private TokenGenerateService tokenGenerateService;

	@PostMapping("/register")
	public String registerUser(@RequestBody @Valid SystemUser systemUser) {
		userService.create(systemUser);
		return "OK";
	}

	@PostMapping("/auth")
	public AuthResponse auth(@RequestBody AuthRequest request) {
		UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
		String token = tokenGenerateService.generateToken(userEntity.getLogin());
		return new AuthResponse(token);
	}
}
