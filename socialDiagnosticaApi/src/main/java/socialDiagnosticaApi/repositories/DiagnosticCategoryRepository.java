package socialDiagnosticaApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import socialDiagnosticaApi.persistence.entities.data.DiagnosticCategory;


@Repository
public interface DiagnosticCategoryRepository extends CrudRepository<DiagnosticCategory, Long> {

}
