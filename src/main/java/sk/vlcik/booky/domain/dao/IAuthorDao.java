package sk.vlcik.booky.domain.dao;

import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Author;
import sk.vlcik.booky.domain.entity.Book;

import java.util.List;

public interface IAuthorDao extends IGenericDao<Author> {

    List<Book> findAuthorBooks(Long id) throws ItemNotFoundException;

}
