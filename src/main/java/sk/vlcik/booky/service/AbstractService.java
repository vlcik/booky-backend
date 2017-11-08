package sk.vlcik.booky.service;

import org.springframework.beans.factory.annotation.Autowired;
import sk.vlcik.booky.domain.Mapper;

public class AbstractService {

    @Autowired
    protected Mapper mapper;

}
