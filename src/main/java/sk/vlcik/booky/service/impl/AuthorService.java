package sk.vlcik.booky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.dao.IAuthorDao;
import sk.vlcik.booky.dao.IBookDao;
import sk.vlcik.booky.dao.impl.BookDao;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Author;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.service.IAuthorService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthorDao authorDao;

    @Transactional
    @Override
    public Author getAuthor(Long id) throws ItemNotFoundException {
        Author author = authorDao.getEntity(id);
        author.setBooks(authorDao.findAuthorBooks(id));
        return author;
    }

    @Override
    @Transactional
    public List<Book> getAuthorBooks(Long id) throws ItemNotFoundException {
        return authorDao.findAuthorBooks(id);
    }

    @Override
    @Transactional
    public List<Author> getAuthors() {
        return authorDao.findAll();
    }

    @Override
    @Transactional
    public Long addAuthor(Author author) {
        return authorDao.saveEntity(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        authorDao.updateEntity(author);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        authorDao.delete(id);
    }
}
