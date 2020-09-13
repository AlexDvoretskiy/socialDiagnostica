package socialDiagnosticaApi.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import socialDiagnosticaApi.persistence.dto.DiagnosticTestDto;
import socialDiagnosticaApi.persistence.dto.mappers.DiagnosticTestMapper;
import socialDiagnosticaApi.repositories.DiagnosticTestRepository;
import socialDiagnosticaApi.services.interfaces.DiagnosticTestService;


@Service
public class DiagnosticTestServiceImpl implements DiagnosticTestService {
	@Autowired
	private DiagnosticTestRepository diagnosticTestRepository;
	@Autowired
	private DiagnosticTestMapper diagnosticTestMapper;


	@Override
	public DiagnosticTestDto findOneByIdWithQuestions(Long id) {
		return diagnosticTestMapper.mapDiagnosticTestWithQuestionsToDto(diagnosticTestRepository.findOneById(id));
	}

	@Override
	@Transactional
	public void create(DiagnosticTestDto diagnosticTestDto) {
		diagnosticTestRepository.save(diagnosticTestMapper.mapDiagnosticTestFromDto(diagnosticTestDto));
	}
}
