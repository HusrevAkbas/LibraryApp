package app.library.business.abstracts;

import app.library.entities.concretes.Book;
import app.library.entities.concretes.BookInUse;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;

import java.util.List;

public interface BookInUseService {
    public DataResult<List<BookInUse>> findAllBooksInUse();
    public DataResult<BookInUse> findBookInUseById(Long id);
    public Result delete(Long id);
    public Result add(BookInUse book);
    public Result update(BookInUse book);
}
