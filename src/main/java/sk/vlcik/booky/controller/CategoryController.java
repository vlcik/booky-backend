package sk.vlcik.booky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Category;
import sk.vlcik.booky.service.ICategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/categories")
    @ResponseBody
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/categories/{id}")
    @ResponseBody
    public ResponseEntity<Category> getCategory(@PathVariable Long id) throws ItemNotFoundException {
        return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
    }

    @PostMapping(value = "/categories", headers="Accept=application/json")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {

        categoryService.addCategory(category);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/categories/{id}", headers="Accept=application/json")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {

        category.setId(id);
        categoryService.updateCategory(category);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}