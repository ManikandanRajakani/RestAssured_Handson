package param;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryParam {

    public static void main(String[] args){
        queryParamTest();
    }

    private static void queryParamTest(){
            given()
                    .contentType(ContentType.JSON)
                    .queryParam("id","88f3")
                    .when()
                    .get("http://localhost:3000/students")
                    .then()
                    .statusCode(200)
                    .log()
                    .all();

    }
}
