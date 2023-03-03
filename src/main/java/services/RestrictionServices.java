package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestrictionServices {
    public static Response findRestrictionbyCpf(String cpf){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("api/v1/restricoes/{cpf}",cpf);
    }
}
