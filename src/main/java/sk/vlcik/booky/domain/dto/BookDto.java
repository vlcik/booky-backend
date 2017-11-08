package sk.vlcik.booky.domain.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sk.vlcik.booky.domain.entity.Author;
import sk.vlcik.booky.domain.entity.Category;
import sk.vlcik.booky.domain.entity.Status;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BookDto implements Serializable {

    private Long id;

    private String name;

    private AuthorDto author;

    private Category category;

    private Status status;

}
