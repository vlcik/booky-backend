package sk.vlcik.booky.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.service.IBookService;

import java.util.List;

@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    @GetMapping("/")
    @ResponseBody
    List<Book> home() {
        List<Book> books = bookService.findAll();
        logger.debug(books.toString());
        return books;
    }

    @PostMapping("/book/add")
    @ResponseBody
    List<Book> addBook() {
        List<Book> books = bookService.findAll();
        logger.debug(books.toString());
        return books;
    }
}