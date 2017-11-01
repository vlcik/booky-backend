package sk.vlcik.booky.dao;

import sk.vlcik.booky.model.Author;
import sk.vlcik.booky.model.Book;

import java.util.List;

public interface IAuthorDao {

    List<Book> getAuthorBooks(Author author);

}
