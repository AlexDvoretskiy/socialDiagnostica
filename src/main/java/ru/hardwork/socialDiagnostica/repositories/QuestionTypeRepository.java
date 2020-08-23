package ru.hardwork.socialDiagnostica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.hardwork.socialDiagnostica.persistence.entities.data.QuestionType;


@Repository
public interface QuestionTypeRepository extends CrudRepository<QuestionType, Long> {
	QuestionType findOneById(Long id);
}
