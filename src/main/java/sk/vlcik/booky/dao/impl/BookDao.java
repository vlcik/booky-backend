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

    @Override
    public List<Book> findAll() {
        return super.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return super.getEntity(id);
    }

    @Override
    public Book addBook(Book book) {
        return super.saveEntity(book);
    }

    @Override
    public List<Book> findAuthorBooks(Author author) {
        return getSession().createQuery("SELECT b FROM Book b WHERE b.author=:author")
                .setParameter("author", author)
                .getResultList();
    }
}
