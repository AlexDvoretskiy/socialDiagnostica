package ru.hardwork.socialDiagnostica.persistence.entities.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import ru.hardwork.socialDiagnostica.persistence.tables.DiagnosticAnswerTableDesc;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Table(name = DiagnosticAnswerTableDesc.SYSTEM_NAME)
public class DiagnosticAnswer {

	@Id
	@Column(name = DiagnosticAnswerTableDesc.ID_FIELD)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = DiagnosticAnswerTableDesc.QUESTION_ID_FIELD)
	private DiagnosticQuestion diagnosticQuestion;

	@Column(name = DiagnosticAnswerTableDesc.DESCRIPTION_FIELD)
	private String description;

	@Column(name = DiagnosticAnswerTableDesc.COST_FIELD)
	private String cost;


	@Builder
	public DiagnosticAnswer(DiagnosticQuestion diagnosticQuestion, String description, String cost) {
		this.diagnosticQuestion = diagnosticQuestion;
		this.description = description;
		this.cost = cost;
	}
}
