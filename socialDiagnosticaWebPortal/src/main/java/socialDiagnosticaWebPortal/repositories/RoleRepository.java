package socialDiagnosticaWebPortal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import socialDiagnosticaWebPortal.persistence.entites.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findOneByName(String name);
}
