package ru.hardwork.socialDiagnostica.persistence.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class DiagnosticCategoryDto {
	private String name;
	private String color;

	private List<DiagnosticTestDto> tests;
}
