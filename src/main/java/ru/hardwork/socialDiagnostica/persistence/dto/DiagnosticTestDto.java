package ru.hardwork.socialDiagnostica.persistence.dto;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Builder;
import lombok.Data;

import ru.hardwork.socialDiagnostica.json.CategoryView;


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


	@Builder
	public DiagnosticTestDto(Long id, String name, String description, String questionCount, String duration, DiagnosticMetricDto diagnosticMetricDto) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.questionCount = questionCount;
		this.duration = duration;
		this.diagnosticMetricDto = diagnosticMetricDto;
	}

	public DiagnosticTestDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
