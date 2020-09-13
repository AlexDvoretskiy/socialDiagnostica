package socialDiagnosticaWebPortal.persistence.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiagnosticCategory {
	private Long id;
	private String name;

	private List<DiagnosticTest> tests;
}
