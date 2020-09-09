package socialDiagnosticaWebPortal.persistence.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiagnosticTest {
private Long id;
private String name;
private String description;
private String questionCount;
private String duration;

private List<DiagnosticQuestion> diagnosticQuestions;
		}
