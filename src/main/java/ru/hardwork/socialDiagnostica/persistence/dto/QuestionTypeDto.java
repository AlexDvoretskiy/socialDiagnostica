package ru.hardwork.socialDiagnostica.persistence.dto;


import lombok.Data;


@Data
public class QuestionTypeDto {
	private String name;

	public QuestionTypeDto(String name) {
		this.name = name;
	}
}
