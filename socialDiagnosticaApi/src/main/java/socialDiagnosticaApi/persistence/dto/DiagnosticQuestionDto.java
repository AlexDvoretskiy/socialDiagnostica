package socialDiagnosticaApi.persistence.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class DiagnosticQuestionDto {
	private QuestionTypeDto questionTypeDto;
	private String description;
	private String duration;
	private List<DiagnosticAnswerDto>  diagnosticAnswers;
}
