package crudoperations;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetRequestDemo {
    public static void main(String[] args){

        System.out.println("Welcome to API automation");
        getRequestCall();
    }

    private static void getRequestCall(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .body("data.first_name",equalTo("Janet"))
                .statusCode(200)
                .log()
                .all();

    }
}
