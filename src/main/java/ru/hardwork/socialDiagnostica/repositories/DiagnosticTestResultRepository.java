package ru.hardwork.socialDiagnostica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticTestResult;


@Repository
public interface DiagnosticTestResultRepository extends CrudRepository<DiagnosticTestResult, Long> {
	DiagnosticTestResult findOneById(Long id);
}
