package ru.hardwork.socialDiagnostica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticCategory;


@Repository
public interface DiagnosticCategoryRepository extends CrudRepository<DiagnosticCategory, Long> {

}
