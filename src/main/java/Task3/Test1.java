package Task3;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test1 {

    private Gson gson;
    @BeforeEach
    public void Setup(){
        RestAssured.baseURI = "https://swapi.dev/api/people/1";
        gson= new Gson();
    }
   @Test
    public void TestGet(){
        Response response= given().when().get().then().extract().response();
        System.out.println(response.body().asPrettyString());
       Assertions.assertEquals(200, response.statusCode());
       Assertions.assertEquals("Luke Skywalker", response.jsonPath().getString("name"));
       Assertions.assertEquals("172", response.jsonPath().getString("height"));
       Assertions.assertEquals("77", response.jsonPath().getString("mass"));
       Assertions.assertEquals("blond", response.jsonPath().getString("hair_color"));
       Assertions.assertEquals("fair", response.jsonPath().getString("skin_color"));

}
}
