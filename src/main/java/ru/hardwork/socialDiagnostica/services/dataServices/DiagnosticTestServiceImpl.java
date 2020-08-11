package ru.hardwork.socialDiagnostica.services.dataServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticTestDto;
import ru.hardwork.socialDiagnostica.persistence.dto.mappers.DiagnosticTestMapper;
import ru.hardwork.socialDiagnostica.repositories.DiagnosticTestRepository;
import ru.hardwork.socialDiagnostica.services.dataServices.interfaces.DiagnosticTestService;


@Service
public class DiagnosticTestServiceImpl implements DiagnosticTestService {

	@Autowired
	private DiagnosticTestRepository diagnosticTestRepository;
	@Autowired
	private DiagnosticTestMapper diagnosticTestMapper;

	@Override
	public DiagnosticTestDto findOneById(Long id) {
		return diagnosticTestMapper.mapDiagnosticTestToDto(diagnosticTestRepository.findOneById(id));
	}

	@Override
	@Transactional
	public void create(DiagnosticTestDto diagnosticTestDto) {
		diagnosticTestRepository.save(diagnosticTestMapper.mapDiagnosticTestFromDto(diagnosticTestDto));
	}
}
