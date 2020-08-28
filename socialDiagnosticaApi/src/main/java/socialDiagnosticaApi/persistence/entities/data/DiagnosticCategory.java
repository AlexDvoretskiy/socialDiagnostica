package socialDiagnosticaApi.persistence.entities.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Cascade;

import socialDiagnosticaApi.persistence.tables.DiagnosticCategoryTableDesc;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = DiagnosticCategoryTableDesc.SYSTEM_NAME)
public class DiagnosticCategory {
	@Id
	@Column(name = DiagnosticCategoryTableDesc.ID_FIELD)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = DiagnosticCategoryTableDesc.NAME_FIELD, nullable = false)
	private String name;

	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@OneToMany(mappedBy = "diagnosticCategory", fetch = FetchType.LAZY)
	private List<DiagnosticTest> diagnosticTests;


	@Builder
	public DiagnosticCategory(String name, List<DiagnosticTest> diagnosticTests) {
		this.name = name;
		this.diagnosticTests = diagnosticTests;
	}
}
