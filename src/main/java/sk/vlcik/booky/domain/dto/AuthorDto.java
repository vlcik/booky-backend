package sk.vlcik.booky.domain.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class AuthorDto {

    private Long id;

    private String name;

    @JsonBackReference
    private List<BookDto> books;
}
