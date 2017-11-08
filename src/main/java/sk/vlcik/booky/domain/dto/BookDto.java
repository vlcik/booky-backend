package sk.vlcik.booky.domain.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class BookDto implements Serializable {

    private Long id;

    private String name;

    @JsonManagedReference
    private AuthorDto author;

    private Category category;

    private Status status;

}
