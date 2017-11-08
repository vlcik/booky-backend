package sk.vlcik.booky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.vlcik.booky.domain.Mapper;
import sk.vlcik.booky.domain.dao.IAuthorDao;
import sk.vlcik.booky.domain.dao.IBookDao;
import sk.vlcik.booky.domain.dto.AuthorDto;
import sk.vlcik.booky.domain.dto.BookDto;
import sk.vlcik.booky.exception.ItemNotFoundException;
import sk.vlcik.booky.domain.entity.Author;
import sk.vlcik.booky.domain.entity.Book;
import sk.vlcik.booky.service.AbstractService;
import sk.vlcik.booky.service.IAuthorService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService extends AbstractService implements IAuthorService {

    private IAuthorDao authorDao;

    @Autowired
    public AuthorService(IAuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Transactional
    @Override
    public AuthorDto getAuthor(Long id) throws ItemNotFoundException {
        AuthorDto authorDto = mapper.mapBetweenEntityDto(authorDao.getEntity(id), AuthorDto.class);
        authorDto.setBooks(mapper.mapListEntityDto(authorDao.findAuthorBooks(id), BookDto.class));
        return authorDto;
    }

    @Override
    @Transactional
    public List<BookDto> getAuthorBooks(Long id) throws ItemNotFoundException {
        return mapper.mapListEntityDto(authorDao.findAuthorBooks(id), BookDto.class);
    }

    @Override
    @Transactional
    public List<AuthorDto> getAuthors() {
        return mapper.mapListEntityDto(authorDao.findAll(), AuthorDto.class);
    }

    @Override
    @Transactional
    public Long addAuthor(AuthorDto authorDto) {
        return authorDao.saveEntity(mapper.mapBetweenEntityDto(authorDto, Author.class));
    }

    @Override
    @Transactional
    public void updateAuthor(AuthorDto authorDto) {
        authorDao.updateEntity(mapper.mapBetweenEntityDto(authorDto, Author.class));
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        authorDao.delete(id);
    }
}
