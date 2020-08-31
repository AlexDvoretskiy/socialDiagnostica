package socialDiagnosticaWebPortal.controllers;


import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/specWorkplace")
public class SpecWorkplaceController {

	@GetMapping("/")
	public String getAdminPage() {
		return "specWorkplace";
	}
}
