package ru.hardwork.socialDiagnostica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticAnswer;


@Repository
public interface DiagnosticAnswerRepository extends CrudRepository<DiagnosticAnswer, Long> {
	DiagnosticAnswer findOneById(Long id);
}
