package ru.hardwork.socialDiagnostica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticQuestion;


@Repository
public interface DiagnosticQuestionRepository extends CrudRepository<DiagnosticQuestion, Long> {
	DiagnosticQuestion findOneById(Long id);
}
