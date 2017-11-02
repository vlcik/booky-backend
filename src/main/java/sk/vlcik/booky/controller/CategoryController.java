package sk.vlcik.booky.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.model.Category;
import sk.vlcik.booky.service.ICategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Category getCategory(Long id) {
        return categoryService.getCategory(id);
    }
}