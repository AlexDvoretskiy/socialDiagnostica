package socialDiagnosticaWebPortal.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import socialDiagnosticaWebPortal.exceptions.ResponseNotFoundException;
import socialDiagnosticaWebPortal.persistence.pojo.DiagnosticCategory;
import socialDiagnosticaWebPortal.services.restServices.SocialDiagnosticaService;

import java.util.List;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/workplace")
public class WorkplaceController {
	private final SocialDiagnosticaService socialDiagnosticaService;


	@GetMapping("/categories")
	public String showCategories(Model model) {
		try {
			List<DiagnosticCategory> categories = socialDiagnosticaService.getCategoriesWithTests();
			model.addAttribute("categories", categories);
		} catch (ResponseNotFoundException e) {
			e.printStackTrace();
		}
		return "workplace";
	}
}
