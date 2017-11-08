package sk.vlcik.booky.service;

import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.domain.dto.CategoryDto;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> findAll();
    CategoryDto getCategory(Long id) throws ItemNotFoundException;
    Long addCategory(Category category);
    void updateCategory(Category category);

    List<BookDto> getCategoryBooks(Long id) throws ItemNotFoundException;

    void deleteCategory(Long id);
}
