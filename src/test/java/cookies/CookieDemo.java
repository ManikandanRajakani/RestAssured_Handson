package cookies;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class CookieDemo {

    public static void main(String[] args){
        //getCookies();
        //getCookiesUsingResponse();
        //getCookieUsingResponse();
        getCookiesManipulation();
    }

    private static void getCookies(){
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("https://www.google.com/")
                    .then()
                    .statusCode(200)
                    .log()
                    .cookies();

    }

    private static void getCookiesUsingResponse(){
        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://www.google.com/")
                .then()
                .statusCode(200);
                /*.log()
                .all();*/

        System.out.println(response.extract().cookies());

    }

    private static void getCookieUsingResponse(){
            ValidatableResponse response = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("https://www.google.com/")
                    .then();
            System.out.println(response.extract().cookie("NID"));
    }

    private static void getCookiesManipulation(){
        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://www.google.com/")
                .then();
        System.out.println(response.extract().cookies());
        Map<String, String> cookies = response.extract().cookies();
        for(Map.Entry<String, String> cookie:cookies.entrySet()){
            System.out.println(cookie.getKey()+ "==" +cookie.getValue());
        }

    }
}
