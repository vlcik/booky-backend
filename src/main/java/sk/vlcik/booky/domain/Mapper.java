package sk.vlcik.booky.domain;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sk.vlcik.booky.domain.dto.*;
import sk.vlcik.booky.domain.entity.*;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    private final MapperFactory mapperFactory;

    @Autowired
    public Mapper(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
        configure(mapperFactory);
    }

    protected void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Author.class, AuthorDto.class)
                .byDefault()
                .register();
        mapperFactory.classMap(Book.class, BookDto.class)
                .byDefault()
                .register();
        mapperFactory.classMap(Category.class, CategoryDto.class)
                .byDefault()
                .register();
    }

    public <T, U> U mapBetweenEntityDto(T source, Class<U> dest){
        return mapBetweenEntityDtoInternal(source, dest);
    }

    public <T, U> List<U> mapListEntityDto(List<T> list, Class<U> dest){
        return list
                .stream()
                .map(item -> mapBetweenEntityDtoInternal(item, dest))
                .collect(Collectors.toList());
    }

    private <T, U> U mapBetweenEntityDtoInternal(T source, Class<U> dest){
        return mapperFactory.getMapperFacade().map(source, dest);
    }
}

