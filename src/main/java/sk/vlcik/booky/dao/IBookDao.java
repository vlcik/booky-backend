package sk.vlcik.booky.dao;

import sk.vlcik.booky.model.Author;
import sk.vlcik.booky.model.Book;

import java.util.List;

public interface IBookDao {

    List<Book> findAll();

    Book getBook(Long id);

    Book addBook(Book book);

    List<Book> findAuthorBooks(Author author);

}
