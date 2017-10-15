package sk.vlcik.booky.service;

import sk.vlcik.booky.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
}
