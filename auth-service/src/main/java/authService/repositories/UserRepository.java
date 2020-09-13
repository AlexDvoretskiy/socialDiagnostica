package authService.repositories;

import authService.persistence.entites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findOneByName(String name);
}
