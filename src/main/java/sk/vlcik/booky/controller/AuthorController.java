package sk.vlcik.booky.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.domain.Mapper;
import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.domain.entity.Author;
import sk.vlcik.booky.domain.dto.AuthorDto;
import sk.vlcik.booky.service.IAuthorService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private IAuthorService authorService;

    @Autowired
    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/authors/{authorId:[\\d]+}", method = RequestMethod.GET)
    @ResponseBody
    public AuthorDto getAuthor(@PathVariable Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @GetMapping(value = "/authors")
    public List<AuthorDto> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping(value = "/authors/{id}/books")
    public List<BookDto> getAuthorBooks(@PathVariable Long id) {
        return authorService.getAuthorBooks(id);
    }

    @PostMapping(value = "/authors", headers="Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addAuthor(@RequestBody @Valid AuthorDto author) {
        return authorService.addAuthor(author);
    }

    @PutMapping(value = "/authors/{id}", headers="Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable Long id, @RequestBody AuthorDto author) {
        authorService.updateAuthor(author);
    }

    @DeleteMapping(value = "/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}