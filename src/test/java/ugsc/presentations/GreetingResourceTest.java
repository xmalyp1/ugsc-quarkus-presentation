package ugsc.presentations;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import ugsc.presentations.model.GreetingDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/greeting")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    public void testCreateGreetingEndpoint(){
        GreetingDTO greetingDTO = new GreetingDTO("Hello","Patrik Maly");
        given().when()
                .contentType(ContentType.JSON)
                .body(greetingDTO)
                .post("/greeting")
                .then()
                .log().all().statusCode(200);
    }

    @Test
    public void printAllGreetings(){
        given().when()
                .get("/greeting/all")
                .then().log().all().statusCode(200);
    }

}