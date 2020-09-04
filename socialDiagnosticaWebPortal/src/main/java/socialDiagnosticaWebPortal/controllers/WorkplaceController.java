package socialDiagnosticaWebPortal.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import socialDiagnosticaWebPortal.exceptions.ResponseNotFoundException;
import socialDiagnosticaWebPortal.services.restServices.SocialDiagnosticaService;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/workplace")
public class WorkplaceController {
	private final SocialDiagnosticaService socialDiagnosticaService;

	@GetMapping("/")
	public String getAdminPage() {
		try {
			socialDiagnosticaService.getCategoriesWithTests();
		} catch (ResponseNotFoundException e) {
			e.printStackTrace();
		}
		return "workplace";
	}
}
