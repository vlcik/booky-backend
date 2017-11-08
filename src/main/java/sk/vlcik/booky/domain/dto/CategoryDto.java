package sk.vlcik.booky.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class CategoryDto implements Serializable {

    private Long id;

    private String name;

    private int status;

    private List<BookDto> books;


}
