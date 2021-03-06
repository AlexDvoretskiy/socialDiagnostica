package socialDiagnosticaApi.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import socialDiagnosticaApi.persistence.tables.QuestionTypeTableDesc;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Table(name = QuestionTypeTableDesc.SYSTEM_NAME)
public class QuestionType {

	@Id
	@Column(name = QuestionTypeTableDesc.ID_FIELD)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = QuestionTypeTableDesc.NAME_FIELD, nullable = false)
	private String name;


	public QuestionType(String name) {
		this.name = name;
	}
}
