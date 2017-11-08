package sk.vlcik.booky.service;

import sk.vlcik.booky.domain.dto.AuthorDto;
import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Author;

import java.util.List;

public interface IAuthorService {
    AuthorDto getAuthor(Long id) throws ItemNotFoundException;
    List<BookDto> getAuthorBooks(Long id) throws ItemNotFoundException;
    List<AuthorDto> getAuthors();
    Long addAuthor(Author author);
    void updateAuthor(Author author);
    void deleteAuthor(Long id);
}
