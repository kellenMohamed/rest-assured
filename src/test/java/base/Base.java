package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class Base {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://localhost:8080/";
    }
}
