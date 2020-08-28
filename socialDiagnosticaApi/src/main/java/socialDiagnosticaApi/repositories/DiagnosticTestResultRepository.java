package socialDiagnosticaApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import socialDiagnosticaApi.persistence.entities.data.DiagnosticTestResult;


@Repository
public interface DiagnosticTestResultRepository extends CrudRepository<DiagnosticTestResult, Long> {
	DiagnosticTestResult findOneById(Long id);
}
