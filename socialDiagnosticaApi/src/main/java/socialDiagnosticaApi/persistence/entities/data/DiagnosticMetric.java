package socialDiagnosticaApi.persistence.entities.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import socialDiagnosticaApi.persistence.tables.DiagnosticMetricTableDesc;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Table(name = DiagnosticMetricTableDesc.SYSTEM_NAME)
public class DiagnosticMetric {

	@Id
	@Column(name = DiagnosticMetricTableDesc.ID_FIELD)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = DiagnosticMetricTableDesc.METRIC_FORMULA_FIELD)
	private String formula;

	@Column(name = DiagnosticMetricTableDesc.DESCRIPTION_FIELD)
	private String description;


	@Builder
	public DiagnosticMetric(String formula, String description) {
		this.formula = formula;
		this.description = description;
	}
}
