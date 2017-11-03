package sk.vlcik.booky.dao.impl;

import org.springframework.stereotype.Repository;
import sk.vlcik.booky.dao.IAuthorDao;
import sk.vlcik.booky.dao.GenericDao;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Author;
import sk.vlcik.booky.model.Book;

import java.util.List;

@Repository
public class AuthorDao extends GenericDao<Author> implements IAuthorDao {

    @Override
    public Class<Author> getModelClass() {
        return Author.class;
    }

    @Override
    public List<Book> findAuthorBooks(Long id) throws ItemNotFoundException {
        Author author = getEntity(id);
        return getSession().createQuery("SELECT b FROM Book b WHERE b.author=:author")
                .setParameter("author", author)
                .getResultList();
    }
}
