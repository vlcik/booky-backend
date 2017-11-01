package sk.vlcik.booky.service;

import sk.vlcik.booky.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void addBook(Book book);
    void deleteBook(Book book);
    Book getBook(Book book);
}
