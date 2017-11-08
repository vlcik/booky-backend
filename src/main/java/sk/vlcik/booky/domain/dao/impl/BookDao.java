package sk.vlcik.booky.domain.dao.impl;

import org.springframework.stereotype.Repository;
import sk.vlcik.booky.domain.dao.IBookDao;
import sk.vlcik.booky.domain.dao.GenericDao;
import sk.vlcik.booky.domain.entity.Book;

@Repository
public class BookDao extends GenericDao<Book> implements IBookDao {

    @Override
    public Class<Book> getModelClass() {
        return Book.class;
    }

}
