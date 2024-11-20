package crudoperations;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class PutRequestDemo {

    public static void main(String[] args){
        putRequestCall();
    }

    private static void putRequestCall(){
            given().contentType(ContentType.JSON)
                    .body("{\n" +
                            "    \"id\": \"1\",\n" +
                            "    \"name\": \"John Micheal\",\n" +
                            "    \"rollNumber\": 5366,\n" +
                            "    \"email\": \"johnsmith@test.com\"\n" +
                            "}")
                    .when()
                    .put("http://localhost:3000/students/1")
                    .then()
                    .statusCode(200)
                    .log()
                    .all();
    }
}
