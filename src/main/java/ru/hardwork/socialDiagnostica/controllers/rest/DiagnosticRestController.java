package ru.hardwork.socialDiagnostica.controllers.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticCategoryDto;
import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticTestDto;
import ru.hardwork.socialDiagnostica.services.dataServices.interfaces.DiagnosticCategoryService;
import ru.hardwork.socialDiagnostica.services.dataServices.interfaces.DiagnosticTestService;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/diagnosticApi")
public class DiagnosticRestController {
	private final DiagnosticTestService diagnosticTestService;
	private final DiagnosticCategoryService diagnosticCategoryService;

	@GetMapping("/getCategoriesWithTests")
	public ResponseEntity<List<DiagnosticCategoryDto>> getDiagnosticCategoriesWithTest() {
		List<DiagnosticCategoryDto> categories = diagnosticCategoryService.getAll();

		return CollectionUtils.isNotEmpty(categories) ?
				new ResponseEntity<>(categories, HttpStatus.OK) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getTest")
	public ResponseEntity<DiagnosticTestDto> getDiagnosticTest(@RequestParam(value="id", required=true) long id) {
		DiagnosticTestDto diagnosticTestDto = diagnosticTestService.findOneById(id);

		return diagnosticTestDto != null ?
				new ResponseEntity<>(diagnosticTestDto, HttpStatus.OK) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
