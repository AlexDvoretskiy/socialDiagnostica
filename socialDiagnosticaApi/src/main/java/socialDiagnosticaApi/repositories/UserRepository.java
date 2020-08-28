package socialDiagnosticaApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import socialDiagnosticaApi.persistence.entities.data.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findOneByName(String name);
}
