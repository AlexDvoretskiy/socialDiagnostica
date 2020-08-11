package ru.hardwork.socialDiagnostica.persistence.dto.mappers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticCategoryDto;
import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticTestDto;
import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticCategory;
import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticTest;

import java.util.LinkedList;
import java.util.List;


@Slf4j
@Service
public class DiagnosticCategoryMapper {

	public List<DiagnosticCategoryDto> mapDiagnosticCategoryListToDto(List<DiagnosticCategory> diagnosticCategories) {
		List<DiagnosticCategoryDto> diagnosticCategoryDtoList = new LinkedList<>();

		for (DiagnosticCategory diagnosticCategory : diagnosticCategories) {
			diagnosticCategoryDtoList.add(mapDiagnosticCategoryToDto(diagnosticCategory));
		}
		return diagnosticCategoryDtoList;
	}

	public DiagnosticCategoryDto mapDiagnosticCategoryToDto(DiagnosticCategory diagnosticCategory) {
		List<DiagnosticTest> diagnosticTests = diagnosticCategory.getDiagnosticTests();
		List<DiagnosticTestDto> diagnosticTestDtos = new LinkedList<>();

		for (DiagnosticTest diagnosticTest : diagnosticTests) {
			DiagnosticTestDto diagnosticTestDto = DiagnosticTestDto.builder()
					.name(diagnosticTest.getName())
					.description(diagnosticTest.getDescription())
					.questionCount(diagnosticTest.getQuestionCount())
					.duration(diagnosticTest.getDuration())
			.build();

			diagnosticTestDtos.add(diagnosticTestDto);
		}

		return DiagnosticCategoryDto.builder()
				.name(diagnosticCategory.getName())
				.color(diagnosticCategory.getColor())
				.tests(diagnosticTestDtos)
		.build();
	}
}
