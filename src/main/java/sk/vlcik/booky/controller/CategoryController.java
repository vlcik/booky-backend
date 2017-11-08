package sk.vlcik.booky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.domain.dto.CategoryDto;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Book;
import sk.vlcik.booky.domain.entity.Category;
import sk.vlcik.booky.service.IAuthorService;
import sk.vlcik.booky.service.ICategoryService;

import java.util.List;

@RestController
public class CategoryController {

    private ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

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
    public Long addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/categories/{id}", headers="Accept=application/json")
    public void updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        categoryDto.setId(id);
        categoryService.updateCategory(categoryDto);
    }

    @DeleteMapping(value = "/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}