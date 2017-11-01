package sk.vlcik.booky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.dao.ICategoryDao;
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

}
