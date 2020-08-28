package socialDiagnosticaApi.persistence.entities.data;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import socialDiagnosticaApi.persistence.tables.DiagnosticTestResultTableDesc;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Table(name = DiagnosticTestResultTableDesc.SYSTEM_NAME)
public class DiagnosticTestResult {

	@Id
	@Column(name = DiagnosticTestResultTableDesc.ID_FIELD)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = DiagnosticTestResultTableDesc.TEST_ID_FIELD)
	private DiagnosticTest diagnosticTest;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = DiagnosticTestResultTableDesc.USER_ID)
	private User user;

	@Column(name = DiagnosticTestResultTableDesc.RESULT_VALUE_FIELD, nullable = false)
	private String resultValue;

	@Column(name = DiagnosticTestResultTableDesc.RESULT_DATA_FIELD)
	private String resultDataJson;


	@Builder
	public DiagnosticTestResult(DiagnosticTest diagnosticTest, User user, String resultValue, String resultDataJson) {
		this.diagnosticTest = diagnosticTest;
		this.user = user;
		this.resultValue = resultValue;
		this.resultDataJson = resultDataJson;
	}
}
