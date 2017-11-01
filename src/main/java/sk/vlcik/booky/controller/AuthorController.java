package sk.vlcik.booky.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.vlcik.booky.model.Author;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.service.IAuthorService;

import java.util.List;

@RestController
public class AuthorController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private IAuthorService authorService;

    @RequestMapping(value = "/author/{authorId:[\\d]+}/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getAuthorBooks(@PathVariable Long authorId) {
        List<Book> books = authorService.getAuthorBooks(new Author(authorId));
        logger.debug(books.toString());
        return books;
    }
}