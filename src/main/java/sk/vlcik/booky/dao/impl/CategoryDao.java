package sk.vlcik.booky.dao.impl;

import org.springframework.stereotype.Repository;
import sk.vlcik.booky.dao.GenericDao;
import sk.vlcik.booky.dao.ICategoryDao;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.model.Category;

import java.util.List;

@Repository
public class CategoryDao extends GenericDao<Category> implements ICategoryDao {

    @Override
    public Class<Category> getModelClass() {
        return Category.class;
    }

    @Override
    public List<Book> getCategoryBooks(Long id) throws ItemNotFoundException {
        Category category = getEntity(id);
        return getSession()
                .createQuery("SELECT b FROM Book b WHERE b.category = :category")
                .setParameter("category", category)
                .getResultList();
    }
}
