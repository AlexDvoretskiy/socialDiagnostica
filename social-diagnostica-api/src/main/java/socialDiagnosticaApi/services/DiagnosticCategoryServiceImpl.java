package socialDiagnosticaApi.services;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import socialDiagnosticaApi.persistence.dto.DiagnosticCategoryDto;
import socialDiagnosticaApi.persistence.dto.mappers.DiagnosticCategoryMapper;
import socialDiagnosticaApi.persistence.entities.DiagnosticCategory;
import socialDiagnosticaApi.repositories.DiagnosticCategoryRepository;
import socialDiagnosticaApi.services.interfaces.DiagnosticCategoryService;

import java.util.List;


@Slf4j
@Service
public class DiagnosticCategoryServiceImpl implements DiagnosticCategoryService {

	@Autowired
	private DiagnosticCategoryRepository diagnosticCategoryRepository;
	@Autowired
	private DiagnosticCategoryMapper diagnosticCategoryMapper;


	@Override
	public List<DiagnosticCategoryDto> getAll() {
		List<DiagnosticCategory> diagnosticCategories = Lists.newArrayList(diagnosticCategoryRepository.findAll());
		return diagnosticCategoryMapper.mapCategoryWithTestDataToDto(diagnosticCategories);
	}

	@Override
	public List<DiagnosticCategoryDto> getAllWithTestNamesOnly() {
		List<DiagnosticCategory> diagnosticCategories = Lists.newArrayList(diagnosticCategoryRepository.findAll());
		return diagnosticCategoryMapper.mapCategoryWithTestNameOnlyToDto(diagnosticCategories);
	}
}
