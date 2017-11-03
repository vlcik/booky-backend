package sk.vlcik.booky.service;

import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category getCategory(Long id) throws ItemNotFoundException;
    void addCategory(Category category);
    void updateCategory(Category category);
}
