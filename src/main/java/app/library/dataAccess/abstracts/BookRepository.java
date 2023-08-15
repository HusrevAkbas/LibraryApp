package app.library.dataAccess.abstracts;

import app.library.entities.concretes.Book;
import app.library.utilities.results.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByUserEntityId(Long id);
}
