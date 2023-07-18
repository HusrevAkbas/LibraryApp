package app.library.business.abstracts;

import app.library.entities.concretes.Book;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import java.util.List;

public interface BookService {
    public DataResult<List<Book>> findAllBooks();
    public DataResult<Book> findBookById(Long id);
    public Result delete(Long id);

    public Result add(Book book);
}
