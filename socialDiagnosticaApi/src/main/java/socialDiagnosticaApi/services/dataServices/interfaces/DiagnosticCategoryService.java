package socialDiagnosticaApi.services.dataServices.interfaces;


import org.springframework.stereotype.Service;
import socialDiagnosticaApi.persistence.dto.DiagnosticCategoryDto;
import java.util.List;


@Service
public interface DiagnosticCategoryService {

	List<DiagnosticCategoryDto> getAll();

	List<DiagnosticCategoryDto> getAllWithTestNamesOnly();
}
