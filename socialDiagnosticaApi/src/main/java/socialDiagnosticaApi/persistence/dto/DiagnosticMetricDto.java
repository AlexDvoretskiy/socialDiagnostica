package socialDiagnosticaApi.persistence.dto;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DiagnosticMetricDto {
	private String metricFormula;
	private String description;
}
