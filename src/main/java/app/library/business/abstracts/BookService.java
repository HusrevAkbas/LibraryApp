package app.library.business.abstracts;

import app.library.business.response.BookResponse;
import app.library.entities.concretes.Book;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import java.util.List;

public interface BookService {
    public DataResult<List<BookResponse>> findAllBooks();
    public DataResult<BookResponse> findBookById(Long id);
    public Result delete(Long id);
    public Result add(Book book);
    public Result update(Book book);

    public DataResult<List<Book>> findBooksByUserId(Long id);
}
