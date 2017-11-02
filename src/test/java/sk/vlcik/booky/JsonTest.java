package sk.vlcik.booky;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JsonTest {

    Logger logger = LoggerFactory.getLogger(JsonTest.class);

    @Test()
    public void givenBidirectionRelation_whenSerializing_thenException()
            throws JsonProcessingException {

        User user = new User(1, "John");
        Item item = new Item(2, "book", user);
        user.addItem(item);

        String result = new ObjectMapper().writeValueAsString(item);

        logger.debug(result);
    }

    @Test
    public void mapTest() {
        List<User> users = Arrays.asList(new User(1, "John"), new User(2, "George"), new User(3, "Martina"));

        logger.debug(users
                .stream()
                .map(User::getName)
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
