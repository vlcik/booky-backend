package sk.vlcik.booky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.model.Category;
import sk.vlcik.booky.service.ICategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/categories")
    @ResponseBody
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/categories/{id}")
    @ResponseBody
    public Category getCategory(@PathVariable Long id) throws ItemNotFoundException {
        return categoryService.getCategory(id);
    }

    @GetMapping(value = "/categories/{id}/books")
    @ResponseBody
    public List<Book> getCategoryBooks(@PathVariable Long id) throws ItemNotFoundException {
        return categoryService.getCategoryBooks(id);
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
}