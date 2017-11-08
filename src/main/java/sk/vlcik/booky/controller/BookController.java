package sk.vlcik.booky.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Book;
import sk.vlcik.booky.service.IBookService;

import java.util.List;

@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    @GetMapping(value = {"/", "/books"})
    @ResponseBody
    public List<BookDto> home() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public BookDto getBook(@PathVariable Long id) throws ItemNotFoundException {
        return bookService.getBook(id);
    }

    @PostMapping(value = "/books", headers="Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping(value = "/books/{id}", headers="Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping(value = "/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}