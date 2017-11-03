package sk.vlcik.booky.dao.impl;

import org.springframework.stereotype.Repository;
import sk.vlcik.booky.dao.IBookDao;
import sk.vlcik.booky.dao.GenericDao;
import sk.vlcik.booky.model.Author;
import sk.vlcik.booky.model.Book;

import java.util.List;

@Repository
public class BookDao extends GenericDao<Book> implements IBookDao {

    @Override
    public Class<Book> getModelClass() {
        return Book.class;
    }

}
