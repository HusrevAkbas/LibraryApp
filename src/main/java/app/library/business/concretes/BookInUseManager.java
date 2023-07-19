package app.library.business.concretes;

import app.library.business.abstracts.BookInUseService;
import app.library.dataAccess.abstracts.BookInUseRepository;
import app.library.entities.concretes.BookInUse;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.results.SuccessDataResult;
import app.library.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInUseManager implements BookInUseService {
    BookInUseRepository bookInUseRepository;
    @Autowired
    BookInUseManager(BookInUseRepository bookInUseRepository){
        this.bookInUseRepository = bookInUseRepository;
    }
    @Override
    public DataResult<List<BookInUse>> findAllBooksInUse() {
        return new SuccessDataResult<>(this.bookInUseRepository.findAll(),"Books in use listed");
    }

    @Override
    public DataResult<BookInUse> findBookInUseById(Long id) {
        return new SuccessDataResult<>(this.bookInUseRepository.findById(id).get(),"Books in use listed");
    }

    @Override
    public Result delete(Long id) {
        this.bookInUseRepository.deleteById(id);
        return new SuccessResult("Book in use removed");
    }

    @Override
    public Result add(BookInUse book) {
        this.bookInUseRepository.save(book);
        return new SuccessResult("Book recorded as in use");
    }

    @Override
    public Result update(BookInUse book) {
        this.bookInUseRepository.save(book);
        return new SuccessResult("Book in use updated");
    }
}
