package app.library.business.concretes;

import app.library.business.abstracts.BookService;
import app.library.dataAccess.abstracts.BookRepository;
import app.library.entities.concretes.Book;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.results.SuccessDataResult;
import app.library.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements BookService {
    BookRepository bookRepository;

    @Autowired
    BookManager(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public DataResult<List<Book>> findAllBooks() {
        return new SuccessDataResult<>(this.bookRepository.findAll(),"All books listed");
    }
    @Override
    public DataResult<Book> findBookById(Long id) {
        return new SuccessDataResult<>(this.bookRepository.findById(id).get(),"Book found");
    }
    @Override
    public Result delete(Long id) {
        this.bookRepository.deleteById(id);
        return new SuccessResult("Book removed");
    }
    @Override
    public Result add(Book book) {
        this.bookRepository.save(book);
        return new SuccessResult("Book added");
    }

    @Override
    public Result update(Book book) {
        this.bookRepository.save(book);
        return new SuccessResult("Book updated");
    }

    @Override
    public DataResult<List<Book>> findBooksByUserId(Long id) {
        return new SuccessDataResult<>(this.bookRepository.findByUserEntityId(id),String.format("Here is user %s books",id)) ;
    }
}
