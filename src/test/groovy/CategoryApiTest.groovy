import groovyx.net.http.RESTClient
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class CategoryApiTest extends Specification {

    def "add_category_test"() {
        given:
            def client = new RESTClient("http://localhost:8080/")
        when: "create new category"
            def resp = client.post(
                    path : 'categories',
                    headers : ['Content-Type' : "application/json"],
                    body    : [
                            'name' :  "Category test",
                            'status' : 1
                    ]
            )

        then: "200 status should be returned"
            assert resp.status == 200
    }
}
