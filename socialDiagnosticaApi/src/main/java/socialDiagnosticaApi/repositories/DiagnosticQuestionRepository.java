package socialDiagnosticaApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import socialDiagnosticaApi.persistence.entities.data.DiagnosticQuestion;


@Repository
public interface DiagnosticQuestionRepository extends CrudRepository<DiagnosticQuestion, Long> {
	DiagnosticQuestion findOneById(Long id);
}
