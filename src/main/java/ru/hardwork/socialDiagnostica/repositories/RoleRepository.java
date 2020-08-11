package ru.hardwork.socialDiagnostica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hardwork.socialDiagnostica.persistence.entities.data.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findOneByName(String name);
}
