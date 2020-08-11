package ru.hardwork.socialDiagnostica.persistence.dto.mappers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticTestDto;
import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticTest;


@Slf4j
@Service
@RequiredArgsConstructor
public class DiagnosticTestMapper {
	private final DiagnosticCategoryMapper diagnosticCategoryMapper;

	public DiagnosticTestDto mapDiagnosticTestToDto(DiagnosticTest diagnosticTest) {
		return DiagnosticTestDto.builder()
				.name(diagnosticTest.getName())
				.description(diagnosticTest.getDescription())
				.questionCount(diagnosticTest.getQuestionCount())
				.duration(diagnosticTest.getDuration())
		.build();
	}

	public DiagnosticTest mapDiagnosticTestFromDto(DiagnosticTestDto diagnosticTestDto) {
		return DiagnosticTest.builder()
				.name(diagnosticTestDto.getName())
				.description(diagnosticTestDto.getDescription())
				.questionCount(diagnosticTestDto.getQuestionCount())
				.duration(diagnosticTestDto.getDuration())
		.build();
	}
}
