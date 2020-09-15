package socialDiagnosticaApi.persistence.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import socialDiagnosticaApi.persistence.tables.DiagnosticTestTableDesc;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = DiagnosticTestTableDesc.SYSTEM_NAME)
public class DiagnosticTest {

	@Id
	@Column(name = DiagnosticTestTableDesc.ID_FIELD)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = DiagnosticTestTableDesc.NAME_FIELD, nullable = false)
	private String name;

	@Column(name = DiagnosticTestTableDesc.DESCRIPTION_FIELD)
	private String description;

	@Column(name = DiagnosticTestTableDesc.QUESTION_COUNT_FIELD)
	private String questionCount;

	@Column(name = DiagnosticTestTableDesc.DURATION_FIELD)
	private String duration;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = DiagnosticTestTableDesc.CATEGORY_ID_FIELD)
	private DiagnosticCategory diagnosticCategory;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = DiagnosticTestTableDesc.METRIC_ID_FIELD)
	private DiagnosticMetric diagnosticMetric;

	@OneToMany(mappedBy = "diagnosticTest")
	private List<DiagnosticQuestion> diagnosticQuestions;


	@Builder
	public DiagnosticTest(String name, String description, String questionCount, String duration, DiagnosticCategory diagnosticCategory, DiagnosticMetric diagnosticMetric) {
		this.name = name;
		this.description = description;
		this.questionCount = questionCount;
		this.duration = duration;
		this.diagnosticCategory = diagnosticCategory;
		this.diagnosticMetric = diagnosticMetric;
	}
}
