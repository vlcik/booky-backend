package sk.vlcik.booky.dao.impl;

import org.springframework.stereotype.Repository;
import sk.vlcik.booky.dao.BookDao;
import sk.vlcik.booky.dao.GenericDao;
import sk.vlcik.booky.model.Book;

import java.util.List;

@Repository
public class BookDaoImpl extends GenericDao<Book> implements BookDao {

    @Override
    public Class<Book> getModelClass() {
        return Book.class;
    }

    @Override
    public List<Book> findAll() {
        return super.findAll();
    }
}
