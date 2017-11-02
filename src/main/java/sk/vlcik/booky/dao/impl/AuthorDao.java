package sk.vlcik.booky.dao.impl;

import org.springframework.stereotype.Repository;
import sk.vlcik.booky.dao.IAuthorDao;
import sk.vlcik.booky.dao.GenericDao;
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
    public Author getAuthor(Long id){
        return super.getEntity(id);
    }
}
