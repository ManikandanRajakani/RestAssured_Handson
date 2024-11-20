package response;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class XmlResponseValidation {

    public static void main(String[] args){
        //logXmlResponseValidation();
        //xmlResponseValidation();
        //xmlResponseBodyValidationApproach1();
        //xmlResponseBodyValidationApproach2();
        xmlResponseBodyValidationApproach3();
    }

    private static void logXmlResponseValidation(){
        given()
                .when()
                .get("https://thetestrequest.com/authors/1.xml")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    private static void xmlResponseValidation(){
        given()
                .when()
                .get("https://thetestrequest.com/authors/1.xml")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log()
                .body();
    }

    private static void xmlResponseBodyValidationApproach1(){
        given()
                .when()
                .get("https://thetestrequest.com/authors/1.xml")
                .then()
                .statusCode(200)
                .body("hash.name",equalTo("Karl Konca"));
    }

    private static void xmlResponseBodyValidationApproach2(){
        Response response = given()
                .when()
                .get("https://thetestrequest.com/authors/1.xml");
        //Validate the response using xmlpath
        String email = response.xmlPath().get("hash.email");
        System.out.println("The emailId from xml response is:" +email);
        assertThat(email,equalTo("viva@keebler.biz"));
    }

    
    private static void xmlResponseBodyValidationApproach3(){

        Response response = given()
                .when()
                .get("https://thetestrequest.com/authors/1.xml");
        //Create xmlPathobject

        XmlPath xmlPath = new XmlPath(response.asString());
        List<String> names = xmlPath.getList("objects.object.name");
        for(String name:names){
            System.out.println(name);
        }
       /* for(int i=0;i<names.size();i++){
            System.out.println(names.get(i));
        }*/
        //System.out.println(names.toString());
    }

}
