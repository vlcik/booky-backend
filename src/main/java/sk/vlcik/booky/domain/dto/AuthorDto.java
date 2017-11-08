package sk.vlcik.booky.domain.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Data
public class AuthorDto {

    private Long id;

    @NotBlank
    private String name;

    private List<BookDto> books;
}
