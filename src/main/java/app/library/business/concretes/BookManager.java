package app.library.business.concretes;

import app.library.business.abstracts.BookService;
import app.library.business.response.BookResponse;
import app.library.dataAccess.abstracts.BookRepository;
import app.library.entities.concretes.Book;
import app.library.utilities.mappers.ModelMapperService;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.results.SuccessDataResult;
import app.library.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookManager implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ModelMapperService modelMapperService;

    @Autowired
    BookManager(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public DataResult<List<BookResponse>> findAllBooks() {
        List<BookResponse> bookResponseList = this.bookRepository.findAll().stream().map(book ->
                modelMapperService.response().map(book, BookResponse.class)).toList();
        return new SuccessDataResult<List<app.library.business.response.BookResponse>>(bookResponseList,"All books listed");
    }
    @Override
    public DataResult<BookResponse> findBookById(Long id) {
        BookResponse bookResponse = modelMapperService.response()
                .map(this.bookRepository.findById(id).get(),BookResponse.class);
        return new SuccessDataResult<BookResponse>(bookResponse,"Book found");
    }
    @Override
    public Result delete(Long id) {
        this.bookRepository.deleteById(id);
        return new SuccessResult("Book removed");
    }
    @Override
    public Result add(Book book) {
        this.bookRepository.save(book);
        return new SuccessResult("Book added: " + book.getName());
    }

    @Override
    public Result update(Book book) {
        this.bookRepository.save(book);
        return new SuccessResult("Book updated: "+book.getName());
    }

    @Override
    public DataResult<List<Book>> findBooksByUserId(Long id) {
        return new SuccessDataResult<>(this.bookRepository.findByUserEntityId(id),String.format("Here is user %s books",id)) ;
    }
}
