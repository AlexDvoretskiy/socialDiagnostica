package socialDiagnosticaApi.persistence.entities.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import socialDiagnosticaApi.persistence.tables.DiagnosticQuestionTableDesc;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = DiagnosticQuestionTableDesc.SYSTEM_NAME)
public class DiagnosticQuestion {

	@Id
	@Column(name = DiagnosticQuestionTableDesc.ID_FIELD)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = DiagnosticQuestionTableDesc.TEST_ID_FIELD)
	private DiagnosticTest diagnosticTest;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = DiagnosticQuestionTableDesc.QUESTION_TYPE_ID_FIELD)
	private QuestionType questionType;

	@OneToMany(mappedBy = "diagnosticQuestion")
	private List<DiagnosticAnswer> diagnosticAnswers;

	@Column(name = DiagnosticQuestionTableDesc.DESCRIPTION_FIELD, nullable = false)
	private String description;

	@Column(name = DiagnosticQuestionTableDesc.DURATION_FIELD)
	private String duration;


	@Builder
	public DiagnosticQuestion(DiagnosticTest diagnosticTest, QuestionType questionType, String description, String duration) {
		this.diagnosticTest = diagnosticTest;
		this.questionType = questionType;
		this.description = description;
		this.duration = duration;
	}
}
