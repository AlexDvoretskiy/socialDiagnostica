package socialDiagnosticaWebPortal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import socialDiagnosticaWebPortal.persistence.entites.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findOneByName(String name);
}
