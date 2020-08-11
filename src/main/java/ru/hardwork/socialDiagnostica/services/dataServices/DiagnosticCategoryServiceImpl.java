package ru.hardwork.socialDiagnostica.services.dataServices;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticCategoryDto;
import ru.hardwork.socialDiagnostica.persistence.dto.mappers.DiagnosticCategoryMapper;
import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticCategory;
import ru.hardwork.socialDiagnostica.repositories.DiagnosticCategoryRepository;
import ru.hardwork.socialDiagnostica.services.dataServices.interfaces.DiagnosticCategoryService;

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
		return diagnosticCategoryMapper.mapDiagnosticCategoryListToDto(diagnosticCategories);
	}
}
