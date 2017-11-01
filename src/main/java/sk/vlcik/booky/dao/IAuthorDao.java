package sk.vlcik.booky.dao;

import sk.vlcik.booky.model.Book;

import java.util.List;

public interface IBookDao {

    List<Book> findAll();

}
