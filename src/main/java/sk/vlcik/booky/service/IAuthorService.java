package sk.vlcik.booky.service;

import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Author;
import sk.vlcik.booky.model.Book;

import java.util.List;

public interface IAuthorService {
    Author getAuthor(Long id) throws ItemNotFoundException;
    List<Book> getAuthorBooks(Long id) throws ItemNotFoundException;
    List<Author> getAuthors();
    void addAuthor(Author author);
    void updateAuthor(Author author);
    void deleteAuthor(Long id);
}
