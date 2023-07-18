package app.library.dataAccess.abstracts;

import app.library.entities.concretes.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
