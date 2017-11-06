package sk.vlcik.booky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.dao.ICategoryDao;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.model.Book;
import sk.vlcik.booky.model.Category;
import sk.vlcik.booky.service.ICategoryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Transactional
    @Override
    public List<Category> findAll(){
        return categoryDao.findAll();
    }

    @Override
    @Transactional
    public List<Book> getCategoryBooks(Long id) throws ItemNotFoundException {
        return categoryDao.getCategoryBooks(id);
    }

    @Transactional
    @Override
    public Category getCategory(Long id) throws ItemNotFoundException {
        return categoryDao.getEntity(id);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        categoryDao.updateEntity(category);
    }

    @Override
    @Transactional
    public Long addCategory(Category category) {
        return categoryDao.saveEntity(category);
    }
}
