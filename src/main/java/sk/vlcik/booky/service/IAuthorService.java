package sk.vlcik.booky.service;

import sk.vlcik.booky.model.Author;
import sk.vlcik.booky.model.Book;

import java.util.List;

public interface IAuthorService {
    List<Book> getAuthorBooks(Author author);
}
