package sk.vlcik.booky.dao;

import sk.vlcik.booky.exception.ItemNotFoundException;

import java.util.List;

public interface IGenericDao<T> {
    T saveEntity(T entity);
    void updateEntity(T entity);

    void delete(Long id);
    T getEntity(Long id) throws ItemNotFoundException;

    List<T> findAll();
}
