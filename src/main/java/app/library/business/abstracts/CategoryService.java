package app.library.business.abstracts;

import app.library.entities.concretes.Book;
import app.library.entities.concretes.Category;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;

import java.util.List;

public interface CategoryService {
    public DataResult<List<Category>> findAllCategories();
    public DataResult<Category> findCategoryById(Long id);
    public Result delete(Long id);
    public Result add(Category category);
    public Result update(Category category);
}
