package sk.vlcik.booky.service;

import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category getCategory(Long id) throws ItemNotFoundException;
    Long addCategory(Category category);
    void updateCategory(Category category);

    List<Book> getCategoryBooks(Long id) throws ItemNotFoundException;
}
