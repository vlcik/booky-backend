package sk.vlcik.booky.dao;

import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.model.Category;

import java.util.List;

public interface ICategoryDao extends IGenericDao<Category> {

    List<Book> getCategoryBooks(Long id) throws ItemNotFoundException;

}
