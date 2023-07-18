package app.library.business.concretes;

import app.library.business.abstracts.CategoryService;
import app.library.dataAccess.abstracts.CategoryRepository;
import app.library.entities.concretes.Category;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import app.library.utilities.results.SuccessDataResult;
import app.library.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {
    CategoryRepository categoryRepository;
    @Autowired
    CategoryManager(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public DataResult<List<Category>> findAllCategories() {
        return new SuccessDataResult<>(this.categoryRepository.findAll(),"All categories listed");
    }

    @Override
    public DataResult<Category> findCategoryById(Long id) {
        return new SuccessDataResult<>(this.categoryRepository.findById(id).get(),"Category found");
    }

    @Override
    public Result delete(Long id) {
        this.categoryRepository.deleteById(id);
        return new SuccessResult("Category deleted");
    }

    @Override
    public Result add(Category category) {
        this.categoryRepository.save(category);
        return new SuccessResult("Category added");
    }

    @Override
    public Result update(Category category) {
        this.categoryRepository.save(category);
        return new SuccessResult("Category updated");
    }
}
