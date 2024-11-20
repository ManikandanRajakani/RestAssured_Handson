package crudoperations;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestDemo {

    public static void main(String[] args){
        postRequestCall();
    }

    private static void postRequestCall(){
        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"students\": [\n" +
                        "    {\n" +
                        "      \"id\": \"1\",\n" +
                        "      \"name\": \"John Smith\",\n" +
                        "      \"rollNumber\": 5366,\n" +
                        "      \"email\": \"johnsmith@test.com\"\n" +
                        "    }\n" +
                        "\t]\n" +
                        "}")
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .log()
                .all();
    }
}
