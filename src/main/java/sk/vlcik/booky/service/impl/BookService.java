package sk.vlcik.booky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.domain.dao.IAuthorDao;
import sk.vlcik.booky.domain.dao.IBookDao;
import sk.vlcik.booky.domain.dao.ICategoryDao;
import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.domain.dto.CreateBookDto;
import sk.vlcik.booky.domain.entity.Status;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Book;
import sk.vlcik.booky.service.AbstractService;
import sk.vlcik.booky.service.IAuthorService;
import sk.vlcik.booky.service.IBookService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService extends AbstractService implements IBookService {

    private IBookDao bookDao;
    private IAuthorDao authorDao;
    private ICategoryDao categoryDao;

    @Autowired
    public BookService(IBookDao bookDao, IAuthorDao authorDao, ICategoryDao categoryDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @Transactional
    @Override
    public List<BookDto> findAll(){
        return mapper.mapListEntityDto(bookDao.findAll(), BookDto.class);
    }

    @Override
    @Transactional
    public Long addBook(CreateBookDto bookDto) {
        Book book = mapper.mapBetweenEntityDto(bookDto, Book.class);
        book.setAuthor(authorDao.getEntity(bookDto.getAuthorId()));
        book.setCategory(categoryDao.getEntity(bookDto.getCategoryId()));
        book.setStatus(Status.createStatus(bookDto.getStatusId()));

        return bookDao.saveEntity(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        bookDao.delete(id);
    }

    @Override
    @Transactional
    public void updateBook(BookDto bookDto) {
        bookDao.updateEntity(mapper.mapBetweenEntityDto(bookDto, Book.class));
    }

    @Override
    @Transactional
    public BookDto getBook(Long id) throws ItemNotFoundException {
        return mapper.mapBetweenEntityDto(bookDao.getEntity(id), BookDto.class);
    }
}
