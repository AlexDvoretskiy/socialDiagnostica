package ru.hardwork.socialDiagnostica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticMetric;


@Repository
public interface DiagnosticMetricRepository extends CrudRepository<DiagnosticMetric, Long> {
	DiagnosticMetric findOneById(Long id);
}
