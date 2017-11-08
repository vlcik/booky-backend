package sk.vlcik.booky.service;

import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.domain.dto.CreateBookDto;
import sk.vlcik.booky.exception.ItemNotFoundException;

import java.util.List;

public interface IBookService {
    List<BookDto> findAll();
    Long addBook(CreateBookDto book);
    void deleteBook(Long id);
    void updateBook(BookDto book);
    BookDto getBook(Long id) throws ItemNotFoundException;
}
