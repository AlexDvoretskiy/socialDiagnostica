package socialDiagnosticaApi.services.interfaces;

import org.springframework.stereotype.Service;
import socialDiagnosticaApi.persistence.dto.DiagnosticTestDto;


@Service
public interface DiagnosticTestService {

	DiagnosticTestDto findOneByIdWithQuestions(Long id);

	void create(DiagnosticTestDto diagnosticTestDto);
}
