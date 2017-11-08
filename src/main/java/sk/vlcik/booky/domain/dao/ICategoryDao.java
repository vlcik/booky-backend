package sk.vlcik.booky.domain.dao;

import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Book;
import sk.vlcik.booky.domain.entity.Category;

import java.util.List;

public interface ICategoryDao extends IGenericDao<Category> {

    List<Book> getCategoryBooks(Long id) throws ItemNotFoundException;

}
