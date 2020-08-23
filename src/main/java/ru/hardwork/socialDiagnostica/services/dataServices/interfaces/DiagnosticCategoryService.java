package ru.hardwork.socialDiagnostica.services.dataServices.interfaces;


import org.springframework.stereotype.Service;
import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticCategoryDto;

import java.util.List;


@Service
public interface DiagnosticCategoryService {

	List<DiagnosticCategoryDto> getAll();

	List<DiagnosticCategoryDto> getAllWithTestNamesOnly();
}
