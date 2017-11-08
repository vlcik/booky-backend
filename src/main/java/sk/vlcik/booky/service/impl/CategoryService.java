package sk.vlcik.booky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.domain.dao.ICategoryDao;
import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.domain.dto.CategoryDto;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Book;
import sk.vlcik.booky.domain.entity.Category;
import sk.vlcik.booky.service.AbstractService;
import sk.vlcik.booky.service.ICategoryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService extends AbstractService implements ICategoryService {

    private ICategoryDao categoryDao;

    @Autowired
    public CategoryService(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Transactional
    @Override
    public List<CategoryDto> findAll(){
        return mapper.mapListEntityDto(categoryDao.findAll(), CategoryDto.class);
    }

    @Override
    @Transactional
    public List<BookDto> getCategoryBooks(Long id) throws ItemNotFoundException {
        return mapper.mapListEntityDto(categoryDao.getCategoryBooks(id), BookDto.class);
    }

    @Transactional
    @Override
    public CategoryDto getCategory(Long id) throws ItemNotFoundException {
        return mapper.mapBetweenEntityDto(categoryDao.getEntity(id), CategoryDto.class);
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

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        categoryDao.delete(id);
    }
}
