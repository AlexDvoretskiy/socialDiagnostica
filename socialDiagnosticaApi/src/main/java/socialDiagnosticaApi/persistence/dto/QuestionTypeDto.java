package socialDiagnosticaApi.persistence.dto;


import lombok.Data;


@Data
public class QuestionTypeDto {
	private String name;

	public QuestionTypeDto(String name) {
		this.name = name;
	}
}
