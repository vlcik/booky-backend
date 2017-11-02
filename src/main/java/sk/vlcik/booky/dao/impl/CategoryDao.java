package sk.vlcik.booky.dao.impl;

import org.springframework.stereotype.Repository;
import sk.vlcik.booky.dao.GenericDao;
import sk.vlcik.booky.dao.ICategoryDao;
import sk.vlcik.booky.model.Category;

import java.util.List;

@Repository
public class CategoryDao extends GenericDao<Category> implements ICategoryDao {

    @Override
    public Class<Category> getModelClass() {
        return Category.class;
    }

    @Override
    public List<Category> findAll() {
        return super.findAll();
    }

    @Override
    public Category find(Long id) {
        return super.getEntity(id);
    }
}
