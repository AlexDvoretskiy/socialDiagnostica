package ru.hardwork.socialDiagnostica.persistence.dto.mappers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticMetricDto;
import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticTestDto;
import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticTest;


@Slf4j
@Service
public class DiagnosticTestMapper {

	public DiagnosticTestDto mapDiagnosticTestToDto(DiagnosticTest diagnosticTest) {
		DiagnosticMetricDto diagnosticMetricDto = DiagnosticMetricDto.builder()
				.metricFormula(diagnosticTest.getDiagnosticMetric().getFormula())
				.description(diagnosticTest.getDiagnosticMetric().getDescription())
		.build();

		return DiagnosticTestDto.builder()
				.id(diagnosticTest.getId())
				.name(diagnosticTest.getName())
				.description(diagnosticTest.getDescription())
				.questionCount(diagnosticTest.getQuestionCount())
				.duration(diagnosticTest.getDuration())
				.diagnosticMetricDto(diagnosticMetricDto)
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

	public DiagnosticTestDto mapDiagnosticTestWithNameOnlyToDto(DiagnosticTest diagnosticTest) {
		return new DiagnosticTestDto(diagnosticTest.getId(), diagnosticTest.getName());
	}
}
