package services;


import builder.RequestBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SimulatorServices {
    public static Response findSimulators(){
        return given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("api/v1/simulacoes");
    }
    public static Response findSimulatorsByCpf(String cpf){
        return given()
                    .contentType(ContentType.JSON)
                .when()
                .log().all()
                    .get("api/v1/simulacoes/{cpf}",cpf);
    }

    public static  Response postSimulator(HashMap<String,String>body){
        return given()
                    .contentType(ContentType.JSON)
                    .body(body)
                .log().all()
               .when()
                    .post("api/v1/simulacoes");
    }

    public static  Response putSimulator(HashMap<String,String>body,String cpf){
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("api/v1/simulacoes/{cpf}",cpf);
    }

    public static Response deleteSimulatorById(int id) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .delete("api/v1/simulacoes/{id}",id);
    }
}
