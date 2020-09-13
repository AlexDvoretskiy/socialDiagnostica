package socialDiagnosticaWebPortal.persistence.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiagnosticQuestion {
	private QuestionType questionType;
	private String description;
	private String duration;
	private List<DiagnosticAnswer> diagnosticAnswers;
}
