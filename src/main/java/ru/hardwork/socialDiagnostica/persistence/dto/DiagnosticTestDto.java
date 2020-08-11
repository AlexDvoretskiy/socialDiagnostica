package ru.hardwork.socialDiagnostica.persistence.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DiagnosticTestDto {
	private String name;
	private String description;
	private String questionCount;
	private String duration;
}
