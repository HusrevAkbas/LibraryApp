package app.library.dataAccess.abstracts;

import app.library.entities.concretes.BookInUse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInUseRepository extends JpaRepository<BookInUse, Long> {
}
