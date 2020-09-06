package socialDiagnosticaApi.persistence.dto;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Builder;
import lombok.Data;
import socialDiagnosticaApi.json.CategoryView;
import socialDiagnosticaApi.json.TestView;


import java.util.List;


@Data
public class DiagnosticTestDto {
	private Long id;
	private String name;

	@JsonView(CategoryView.WITH_DESCRIPTION.class)
	private String description;
	@JsonView(CategoryView.WITH_DESCRIPTION.class)
	private String questionCount;
	@JsonView(CategoryView.WITH_DESCRIPTION.class)
	private String duration;
	@JsonView(CategoryView.INCLUDE_METRIC.class)
	private DiagnosticMetricDto diagnosticMetric;
	@JsonView(TestView.INCLUDE_QUESTIONS_DATA.class)
	private List<DiagnosticQuestionDto> diagnosticQuestions;


	@Builder
	public DiagnosticTestDto(Long id, String name, String description, String questionCount, String duration, DiagnosticMetricDto diagnosticMetric, List<DiagnosticQuestionDto> diagnosticQuestions) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.questionCount = questionCount;
		this.duration = duration;
		this.diagnosticMetric = diagnosticMetric;
		this.diagnosticQuestions = diagnosticQuestions;
	}

	public DiagnosticTestDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
