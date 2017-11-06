package sk.vlcik.booky.service;

import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Long addBook(Book book);
    void deleteBook(Long id);
    void updateBook(Book book);
    Book getBook(Long id) throws ItemNotFoundException;
}
