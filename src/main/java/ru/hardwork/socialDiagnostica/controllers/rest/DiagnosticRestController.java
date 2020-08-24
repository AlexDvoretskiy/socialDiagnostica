package ru.hardwork.socialDiagnostica.controllers.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import ru.hardwork.socialDiagnostica.json.CategoryView;
import ru.hardwork.socialDiagnostica.json.TestView;
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

	@GetMapping("/getTestWithQuestionsAndAnswers/{id}")
	public String getDiagnosticTest(@PathVariable("id") long id) throws JsonProcessingException {
		DiagnosticTestDto diagnosticTestDto = diagnosticTestService.findOneByIdWithQuestions(id);
		ObjectWriter objectWriter = objectMapper.writerWithView(TestView.INCLUDE_QUESTIONS_DATA.class);
		return objectWriter.writeValueAsString(diagnosticTestDto);
	}
}
