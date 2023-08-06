package app.library.api.controllers;

import app.library.business.abstracts.BookInUseService;
import app.library.business.concretes.BookInUseManager;
import app.library.entities.concretes.BookInUse;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.results.SuccessDataResult;
import app.library.utilities.results.SuccessResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-in-use")
@AllArgsConstructor
@CrossOrigin
public class BookInUseController {
    BookInUseService bookInUseService;
    @GetMapping("/all")
    public DataResult<List<BookInUse>> findAllBooksInUse() {
        return this.bookInUseService.findAllBooksInUse();
    }

    @GetMapping("/{id}")
    public DataResult<BookInUse> findBookInUseById(@PathVariable Long id) {
        return this.bookInUseService.findBookInUseById(id);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        return  this.bookInUseService.delete(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody BookInUse bookInUse) {
        return this.bookInUseService.add(bookInUse);
    }

    @PutMapping
    public Result update(@RequestBody BookInUse bookInUse) {
        return  this.bookInUseService.update(bookInUse);
    }
}
