package socialDiagnosticaWebPortal.persistence.pojo;


import java.util.List;


public class DiagnosticQuestion {
	private QuestionType questionType;
	private String description;
	private String duration;
	private List<DiagnosticAnswer> diagnosticAnswers;
}
