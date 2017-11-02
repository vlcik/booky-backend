package sk.vlcik.booky.service;

import sk.vlcik.booky.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category getCategory(Long id);
}
