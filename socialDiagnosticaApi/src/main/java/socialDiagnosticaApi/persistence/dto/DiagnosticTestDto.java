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

	@JsonView(CategoryView.ALL.class)
	private String description;
	@JsonView(CategoryView.ALL.class)
	private String questionCount;
	@JsonView(CategoryView.ALL.class)
	private String duration;
	@JsonView(CategoryView.ALL.class)
	private DiagnosticMetricDto diagnosticMetricDto;
	@JsonView(TestView.INCLUDE_QUESTIONS_DATA.class)
	private List<DiagnosticQuestionDto> diagnosticQuestions;


	@Builder
	public DiagnosticTestDto(Long id, String name, String description, String questionCount, String duration, DiagnosticMetricDto diagnosticMetricDto, List<DiagnosticQuestionDto> diagnosticQuestions) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.questionCount = questionCount;
		this.duration = duration;
		this.diagnosticMetricDto = diagnosticMetricDto;
		this.diagnosticQuestions = diagnosticQuestions;
	}

	public DiagnosticTestDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
