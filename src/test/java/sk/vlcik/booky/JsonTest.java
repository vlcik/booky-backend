package sk.vlcik.booky;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
public class JsonTest {

    Logger logger = LoggerFactory.getLogger(JsonTest.class);

    @Test()
    public void givenBidirectionRelation_whenSerializing_thenException()
            throws JsonProcessingException {

        Author author = new Author(1L, "John Snow");

        Book book1 = new Book(1L, "Book1", author);
        Book book2 = new Book(2L, "Book2", author);

        author.setBooks(Arrays.asList(book1, book2));

        String result = new ObjectMapper().writeValueAsString(author);

        logger.debug(result);
    }

    @Test
    public void mapTest() {
        List<Book> books = Arrays.asList(new Book(1L, "John"), new Book(2L, "George"), new Book(3L, "Martina"));

        logger.debug(books
                .stream()
                .map(Book::getName)
                .collect(Collectors.toList())
                .toString()
        );
    }

    @Test
    public void reduceTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers
                .stream()
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

        int count = numbers
                .stream()
                .reduce(12, Integer::sum);

        Consumer<Integer> supplier = System.out::println;
        supplier.accept(count);

    }
}
