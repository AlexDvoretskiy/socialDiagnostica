package ru.hardwork.socialDiagnostica.controllers.view;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class DiagnosticController {

	@GetMapping("/")
	public String getUserPage(Model model) {
		return null;
	}
}
