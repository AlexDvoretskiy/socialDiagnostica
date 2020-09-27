package socialDiagnosticaApi.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.swagger.annotations.ApiOperation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import socialDiagnosticaApi.json.CategoryView;
import socialDiagnosticaApi.json.TestView;
import socialDiagnosticaApi.persistence.dto.DiagnosticCategoryDto;
import socialDiagnosticaApi.persistence.dto.DiagnosticTestDto;
import socialDiagnosticaApi.services.interfaces.DiagnosticCategoryService;
import socialDiagnosticaApi.services.interfaces.DiagnosticTestService;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DiagnosticRestController {
	private final DiagnosticTestService diagnosticTestService;
	private final DiagnosticCategoryService diagnosticCategoryService;

	private final ObjectMapper objectMapper = new ObjectMapper();


	@ApiOperation(value = "Получение всех категорий с тестами и их описанием", response = String.class)
	@ResponseBody
	@GetMapping(value = "/getCategoriesWithTests", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getDiagnosticCategoriesWithTestNames() throws JsonProcessingException {
		List<DiagnosticCategoryDto> categories = diagnosticCategoryService.getAllWithTestNamesOnly();
		ObjectWriter objectWriter = objectMapper.writerWithView(CategoryView.WITH_DESCRIPTION.class);
		log.debug(objectWriter.writeValueAsString(categories));
		return objectWriter.writeValueAsString(categories);
	}

	@ApiOperation(value = "Получение теста с вопросами и ответами по id", response = String.class)
	@ResponseBody
	@GetMapping(value = "/getTestWithQuestionsAndAnswers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getDiagnosticTest(@PathVariable("id") long id) throws JsonProcessingException {
		DiagnosticTestDto diagnosticTestDto = diagnosticTestService.findOneByIdWithQuestions(id);
		ObjectWriter objectWriter = objectMapper.writerWithView(TestView.INCLUDE_QUESTIONS_DATA.class);
		log.debug(objectWriter.writeValueAsString(diagnosticTestDto));
		return objectWriter.writeValueAsString(diagnosticTestDto);
	}
}
