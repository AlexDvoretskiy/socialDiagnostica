package ru.hardwork.socialDiagnostica.persistence.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DiagnosticAnswerDto {
	private String description;
	private String cost;
}
