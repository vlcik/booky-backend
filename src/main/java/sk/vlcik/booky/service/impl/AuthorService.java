package sk.vlcik.booky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.dao.IAuthorDao;
import sk.vlcik.booky.dao.impl.BookDao;
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
    public List<Book> getAuthorBooks(Author author) {
        return authorDao.getAuthorBooks(author);
    }
}
