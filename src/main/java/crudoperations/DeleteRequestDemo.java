package crudoperations;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class DeleteRequestDemo {

    public static void main(String[] args){
        deleteCallApi();
    }

    private static void deleteCallApi(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/students/1")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

}
