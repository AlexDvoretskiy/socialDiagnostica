package socialDiagnosticaApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import socialDiagnosticaApi.persistence.entities.data.DiagnosticAnswer;


@Repository
public interface DiagnosticAnswerRepository extends CrudRepository<DiagnosticAnswer, Long> {
	DiagnosticAnswer findOneById(Long id);
}
