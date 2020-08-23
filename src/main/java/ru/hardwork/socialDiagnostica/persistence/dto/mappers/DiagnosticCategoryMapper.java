package ru.hardwork.socialDiagnostica.persistence.dto.mappers;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class DiagnosticCategoryMapper {
	private final DiagnosticTestMapper diagnosticTestMapper;

	public List<DiagnosticCategoryDto> mapCategoryWithTestNameOnlyToDto(List<DiagnosticCategory> diagnosticCategories) {
		List<DiagnosticCategoryDto> diagnosticCategoryDtoList = new LinkedList<>();

		for (DiagnosticCategory diagnosticCategory : diagnosticCategories) {
			diagnosticCategoryDtoList.add(mapCategoryWithTestNameOnlyToDto(diagnosticCategory));
		}
		return diagnosticCategoryDtoList;
	}

	public List<DiagnosticCategoryDto> mapCategoryWithTestDataToDto(List<DiagnosticCategory> diagnosticCategories) {
		List<DiagnosticCategoryDto> diagnosticCategoryDtoList = new LinkedList<>();

		for (DiagnosticCategory diagnosticCategory : diagnosticCategories) {
			diagnosticCategoryDtoList.add(mapCategoryWithTestDataToDto(diagnosticCategory));
		}
		return diagnosticCategoryDtoList;
	}

	private DiagnosticCategoryDto mapCategoryWithTestNameOnlyToDto(DiagnosticCategory diagnosticCategory) {
		List<DiagnosticTest> diagnosticTests = diagnosticCategory.getDiagnosticTests();
		List<DiagnosticTestDto> diagnosticTestDtos = new LinkedList<>();

		for (DiagnosticTest diagnosticTest : diagnosticTests) {
			diagnosticTestDtos.add(diagnosticTestMapper.mapDiagnosticTestWithNameOnlyToDto(diagnosticTest));
		}

		return DiagnosticCategoryDto.builder()
				.id(diagnosticCategory.getId())
				.name(diagnosticCategory.getName())
				.tests(diagnosticTestDtos)
		.build();
	}

	private DiagnosticCategoryDto mapCategoryWithTestDataToDto(DiagnosticCategory diagnosticCategory) {
		List<DiagnosticTest> diagnosticTests = diagnosticCategory.getDiagnosticTests();
		List<DiagnosticTestDto> diagnosticTestDtos = new LinkedList<>();

		for (DiagnosticTest diagnosticTest : diagnosticTests) {
			diagnosticTestDtos.add(diagnosticTestMapper.mapDiagnosticTestToDto(diagnosticTest));
		}

		return DiagnosticCategoryDto.builder()
				.id(diagnosticCategory.getId())
				.name(diagnosticCategory.getName())
				.tests(diagnosticTestDtos)
		.build();
	}
}
