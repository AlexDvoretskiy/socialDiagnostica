package ru.hardwork.socialDiagnostica.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticTest;

@Repository
public interface DiagnosticTestRepository extends CrudRepository<DiagnosticTest, Long> {
	DiagnosticTest findOneById(Long id);
}
