package sk.vlcik.booky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.domain.dao.IBookDao;
import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Book;
import sk.vlcik.booky.service.AbstractService;
import sk.vlcik.booky.service.IBookService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService extends AbstractService implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Transactional
    @Override
    public List<BookDto> findAll(){
        return mapper.mapListEntityDto(bookDao.findAll(), BookDto.class);
    }

    @Override
    @Transactional
    public Long addBook(Book book) {
        return bookDao.saveEntity(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookDao.delete(id);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDao.updateEntity(book);
    }

    @Override
    @Transactional
    public BookDto getBook(Long id) throws ItemNotFoundException {
        return mapper.mapBetweenEntityDto(bookDao.getEntity(id), BookDto.class);
    }
}
