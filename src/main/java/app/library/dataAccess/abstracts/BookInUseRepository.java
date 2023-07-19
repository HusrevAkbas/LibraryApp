package app.library.dataAccess.abstracts;

import app.library.entities.concretes.BookInUse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInUseRepository extends JpaRepository<BookInUse, Long> {
}
