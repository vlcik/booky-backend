package sk.vlcik.booky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.domain.dto.CategoryDto;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Book;
import sk.vlcik.booky.domain.entity.Category;
import sk.vlcik.booky.service.ICategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/categories")
    @ResponseBody
    public List<CategoryDto> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/categories/{id}")
    @ResponseBody
    public CategoryDto getCategory(@PathVariable Long id) throws ItemNotFoundException {
        return categoryService.getCategory(id);
    }

    @GetMapping(value = "/categories/{id}/books")
    @ResponseBody
    public CategoryDto getCategoryBooks(@PathVariable Long id) throws ItemNotFoundException {
        List<BookDto> books = categoryService.getCategoryBooks(id);
        CategoryDto categoryDto = categoryService.getCategory(id);
        categoryDto.setBooks(books);
        return categoryDto;
    }

    @PostMapping(value = "/categories", headers="Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/categories/{id}", headers="Accept=application/json")
    public void updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.updateCategory(category);
    }

    @DeleteMapping(value = "/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}