package sk.vlcik.booky.service.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.dao.IBookDao;
import sk.vlcik.booky.dao.impl.BookDao;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.service.IBookService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Transactional
    @Override
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    @Transactional
    public Book getBook(Long id) throws ItemNotFoundException {
        Book book = bookDao.getBook(id);
        Hibernate.initialize(book.getAuthor());
        return book;
    }
}
