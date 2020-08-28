package socialDiagnosticaApi.persistence.dto.mappers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import socialDiagnosticaApi.persistence.dto.DiagnosticMetricDto;
import socialDiagnosticaApi.persistence.dto.DiagnosticTestDto;
import socialDiagnosticaApi.persistence.entities.data.DiagnosticTest;


@Slf4j
@Service
@RequiredArgsConstructor
public class DiagnosticTestMapper {
	private final DiagnosticQuestionMapper diagnosticQuestionMapper;


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

	public DiagnosticTestDto mapDiagnosticTestWithQuestionsToDto(DiagnosticTest diagnosticTest) {
		return DiagnosticTestDto.builder()
				.id(diagnosticTest.getId())
				.name(diagnosticTest.getName())
				.description(diagnosticTest.getDescription())
				.questionCount(diagnosticTest.getQuestionCount())
				.duration(diagnosticTest.getDuration())
				.diagnosticQuestions(diagnosticQuestionMapper.mapDiagnosticQuestionToDto(diagnosticTest.getDiagnosticQuestions()))
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
