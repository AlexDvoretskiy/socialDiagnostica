package socialDiagnosticaApi.persistence.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class DiagnosticCategoryDto {
	private Long id;
	private String name;

	private List<DiagnosticTestDto> tests;
}
