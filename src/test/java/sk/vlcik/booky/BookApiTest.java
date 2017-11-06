package sk.vlcik.booky;

import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class BookApiTest {

    @Test
    public void expected_books_returns_200() {
        when().
                get("http://localhost:8080/books").
                then().
                statusCode(200).
                body("size()", equalTo(3));
    }

    @Test
    public void expected_book_returns_200_with_expected_data() {
        when().
                get("http://localhost:8080/books/{id}", 1).
                then().
                statusCode(200).
                body(
                        "id", equalTo(1),
                        "name", equalTo("The Godfather"),
                        "author.id", equalTo(2),
                        "author.name", equalTo("Mario Puzo"),
                        "category.id", equalTo(2),
                        "category.name", equalTo("Art"),
                        "category.status", equalTo(1),
                        "status", equalTo("UNREAD")
                );
    }
}
