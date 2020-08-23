package ru.hardwork.socialDiagnostica.services.dataServices.interfaces;

import org.springframework.stereotype.Service;
import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticTestDto;


@Service
public interface DiagnosticTestService {

	DiagnosticTestDto findOneById(Long id);

	void create(DiagnosticTestDto diagnosticTestDto);
}
