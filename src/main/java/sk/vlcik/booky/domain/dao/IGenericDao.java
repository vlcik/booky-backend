package sk.vlcik.booky.domain.dao;

import sk.vlcik.booky.exception.ItemNotFoundException;

import java.util.List;

public interface IGenericDao<T> {
    Long saveEntity(T entity);
    void updateEntity(T entity);

    void delete(Long id);
    T getEntity(Long id) throws ItemNotFoundException;

    List<T> findAll();
}
