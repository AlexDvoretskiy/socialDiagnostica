package ru.hardwork.socialDiagnostica.controllers.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.hardwork.socialDiagnostica.json.CategoryView;
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

	private final ObjectMapper objectMapper = new ObjectMapper();


	@GetMapping(value = "/getCategoriesWithTests", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getDiagnosticCategoriesWithTestNames() throws JsonProcessingException {
		List<DiagnosticCategoryDto> categories = diagnosticCategoryService.getAllWithTestNamesOnly();
		ObjectWriter objectWriter = objectMapper.writerWithView(CategoryView.EXCLUDE_TEST_DATA.class);
		return objectWriter.writeValueAsString(categories);
	}

	@GetMapping("/getTest")
	public ResponseEntity<DiagnosticTestDto> getDiagnosticTest(@RequestParam(value="id", required=true) long id) {
		DiagnosticTestDto diagnosticTestDto = diagnosticTestService.findOneById(id);

		return diagnosticTestDto != null ?
				new ResponseEntity<>(diagnosticTestDto, HttpStatus.OK) :
				new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
