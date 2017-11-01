package sk.vlcik.booky.dao;

import sk.vlcik.booky.model.Category;

import java.util.List;

public interface ICategoryDao {

    List<Category> findAll();

}
