package ru.hardwork.socialDiagnostica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hardwork.socialDiagnostica.persistence.entities.data.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findOneByName(String name);
}
