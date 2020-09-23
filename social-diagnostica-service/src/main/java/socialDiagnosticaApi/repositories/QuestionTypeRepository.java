package socialDiagnosticaApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import socialDiagnosticaApi.persistence.entities.QuestionType;


@Repository
public interface QuestionTypeRepository extends CrudRepository<QuestionType, Long> {
	QuestionType findOneById(Long id);
}
