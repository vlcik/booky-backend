package sk.vlcik.booky.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.service.IBookService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    @GetMapping(value = {"/", "/books"})
    @ResponseBody
    public ResponseEntity<List<Book>> home() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/books", headers="Accept=application/json")
    public ResponseEntity<Book> update(@RequestBody Book book) {

        Book newBook = bookService.addBook(book);

        return new ResponseEntity<>(newBook, HttpStatus.OK);
    }
}