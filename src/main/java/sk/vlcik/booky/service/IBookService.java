package sk.vlcik.booky.service;

import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Book;

import java.util.List;

public interface IBookService {
    List<BookDto> findAll();
    Long addBook(Book book);
    void deleteBook(Long id);
    void updateBook(Book book);
    BookDto getBook(Long id) throws ItemNotFoundException;
}
