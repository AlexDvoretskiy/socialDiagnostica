package ru.hardwork.socialDiagnostica.controllers.view;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ru.hardwork.socialDiagnostica.persistence.entities.rest.SystemUser;
import ru.hardwork.socialDiagnostica.persistence.entities.data.User;
import ru.hardwork.socialDiagnostica.services.userServices.interfaces.UserService;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/register")
public class RegistrationController {
	private final UserService userService;

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
		userService.create(systemUser);
		return "registerSuccess";
	}
}
