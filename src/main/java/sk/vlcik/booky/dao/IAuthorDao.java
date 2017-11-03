package sk.vlcik.booky.dao;

import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Author;
import sk.vlcik.booky.model.Book;

import java.util.List;

public interface IAuthorDao extends IGenericDao<Author> {

    List<Book> findAuthorBooks(Long id) throws ItemNotFoundException;

}
