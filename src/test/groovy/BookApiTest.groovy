import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class BookApiTest extends Specification {

    @Shared
    def client = new RESTClient("http://localhost:8080/")

    def setupSpec() {
        /* this simplifies exception handling so that Spock doesn't
            swallow the exception! */
        client.handler.failure = client.handler.success
    }

    def "numbers to the power of two"(int a, int b, int c) {
        expect:
            Math.pow(a, b) == c

        where:
            a | b | c
            1 | 2 | 1
            2 | 2 | 4
            3 | 2 | 9
            4 | 2 | 16
            5 | 2 | 25
            6 | 3 | 216
            2 | 4 | 16
    }

    def "test_book_existence"() {
        when:
            def bookId = 3
            def resp = logTime {
                return client.get(path : 'books/' + bookId)
            }
        then:
            resp.responseData.id == 3
            resp.responseData.name == "The Jungle book"
    }

    def logTime(Closure c) {
        def start = System.currentTimeMillis()
        def result = c()
        println ("Result in ms: ${System.currentTimeMillis() - start}")
        return result
    }
}
