package sk.vlcik.booky.service.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.dao.impl.BookDaoImpl;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.service.BookService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDaoImpl bookDao;

    @Transactional
    @Override
    public List<Book> findAll(){
        return bookDao.findAll();
    }
}
