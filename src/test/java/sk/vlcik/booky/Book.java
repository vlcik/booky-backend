package sk.vlcik.booky;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;

    private String name;

    @JsonManagedReference
    private Author author;
}
