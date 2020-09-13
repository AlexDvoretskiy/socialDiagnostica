package socialDiagnosticaWebPortal.persistence.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiagnosticAnswer {
	private String description;
	private String cost;
}
