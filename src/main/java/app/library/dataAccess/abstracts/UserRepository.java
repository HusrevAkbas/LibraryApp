package app.library.dataAccess.abstracts;

import app.library.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
