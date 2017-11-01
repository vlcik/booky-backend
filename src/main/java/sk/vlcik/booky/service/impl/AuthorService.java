package sk.vlcik.booky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.dao.impl.BookDao;
import sk.vlcik.booky.model.Book;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public List<Book> findAll(){
        return bookDao.findAll();
    }
}
