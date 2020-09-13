package socialDiagnosticaWebPortal.controllers;


import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import socialDiagnosticaWebPortal.exceptions.UserRegisterException;
import socialDiagnosticaWebPortal.persistence.SystemUser;
import socialDiagnosticaWebPortal.persistence.entites.User;
import socialDiagnosticaWebPortal.services.authServices.interfaces.UserService;
import socialDiagnosticaWebPortal.services.restServices.SocialDiagnosticaService;

import javax.validation.Valid;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/register")
public class RegistrationController {
	private final UserService userService;
	private final SocialDiagnosticaService socialDiagnosticaService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/")
	public String showRegisterForm(Model model) {
		model.addAttribute("systemUser", new SystemUser());
		return "registerForm";
	}

	@PostMapping("/")
	public String registerUser(@Valid @ModelAttribute("systemUser") SystemUser systemUser, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "registerForm";
		}

		User existingUser = userService.findByUserName(systemUser.getUserName());
		if (existingUser != null) {
			model.addAttribute("error", true);
			return "registerForm";
		}

		try {
			socialDiagnosticaService.register(systemUser);
			userService.create(systemUser);
		} catch (UserRegisterException e) {
			log.error(e.getLocalizedMessage(), e);
			model.addAttribute("error", true);
			return "registerForm";
		}

		return "registerSuccess";
	}
}
