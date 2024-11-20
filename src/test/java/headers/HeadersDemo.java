package headers;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {

    public static void main(String[] args){
        //getResponseHeaders();
        getRequestHeader();
        //getResponseHeader();
    }

    private static void getResponseHeaders(){
            ValidatableResponse response = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("https://reqres.in/api/users/2")
                    .then()
                    .statusCode(200);
        Headers headerRef= response.extract().headers();
        //Approach1 to retrieve Response Header
        //System.out.println(response.extract().headers());
        //Approach2 to retrieve the Response Header using forEach loop
        for(Header header :headerRef){
            System.out.println(header.getName()+ "==>" +header.getValue());
        }
    }

    static void getResponseHeader(){
        ValidatableResponse response1= given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200);
        System.out.println(response1.extract().header("Connection"));
    }

    private static void getRequestHeader(){
              ValidatableResponse response2=  given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("")
                        .then()
                        .statusCode(200);
        System.out.println(response2.extract().contentType());
    }


}
