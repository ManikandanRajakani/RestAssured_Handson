package param;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathParam {

    public static void main(String[] args){
        pathParamFunctionality();
    }

    private static void pathParamFunctionality(){
            given().contentType(ContentType.JSON)
                    .when()
                    .log()
                    .all()
                    .pathParam("student_id","17dc")
                    .get("http://localhost:3000/students/{student_id}")
                    .then()
                    .statusCode(200);
                    /*.log()
                    .body();*/
    }
}
