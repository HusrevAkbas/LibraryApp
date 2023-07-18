package app.library.api.controllers;

import app.library.business.abstracts.CategoryService;
import app.library.entities.concretes.Category;
import app.library.utilities.results.DataResult;
import app.library.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    CategoryService categoryService;
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("/all")
    public DataResult<List<Category>> getAllCategories(){
        return this.categoryService.findAllCategories();
    }
    @GetMapping("/{id}")
    public DataResult<Category> getCategoryById(@PathVariable("id") Long id){
        return this.categoryService.findCategoryById(id);
    }
    @PostMapping("/add")
    public Result addCategory(@RequestBody Category category){
        return this.categoryService.add(category);
    }
    @PutMapping("/update")
    public Result updateCategory(@RequestBody Category category){
        return this.categoryService.update(category);
    }
    @DeleteMapping("/delete/{id}")
    public Result deleteCategory(@PathVariable("id") Long id){
        return this.categoryService.delete(id);
    }
}
