package tests;

import base.Base;
import builder.RequestBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import services.SimulatorServices;
import java.util.HashMap;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class SimulatorTest extends Base {

    @ParameterizedTest
    @MethodSource("data.DataProvider#successDataProviderSimulator")
    public void returnSimulationsOpened(){
        SimulatorServices.findSimulators()
        .then()
                .statusCode(SC_OK)
                .body("nome[0]", notNullValue())
                .body("cpf[0]", notNullValue())
                .body("email[0]",notNullValue())
                .body("valor[0]", notNullValue())
                .body("parcelas[0]", notNullValue())
                .body("seguro[0]", notNullValue());
    }


    @ParameterizedTest
    @MethodSource("data.DataProvider#insertDataProviderSimulator")
    public void insertSimulations(String cpf, String nome, String email, Integer valor,Integer parcelas, Boolean seguro ){
        HashMap<String,String> requestBody = RequestBuilder.requestBodyPost(cpf, nome, email, valor, parcelas, seguro);
        SimulatorServices.postSimulator(requestBody)
                .then()
                .log().all()
                .statusCode(SC_CREATED)
                .body("nome",is(requestBody.get("nome")))
                .body("cpf", is(requestBody.get("cpf")))
                .body("email",is(requestBody.get("email")));
        int id = SimulatorServices.findSimulatorsByCpf(cpf)
                .then()
                .extract().path("id");
        SimulatorServices.deleteSimulatorById(id)
                .then()
                .statusCode(SC_OK);
    }

    @ParameterizedTest
    @MethodSource("data.DataProvider#insertInvalidDataProviderSimulator")
    public void insertInvalidSimulationsValues(String cpf, String nome, String email, Integer valor,Integer parcelas, Boolean seguro ){
        HashMap<String,String> requestBody = RequestBuilder.requestBodyPost(cpf, nome, email, valor, parcelas, seguro);
        SimulatorServices.postSimulator(requestBody)
                .then()
                .log().all()
                .statusCode(SC_BAD_REQUEST);
        int id = SimulatorServices.findSimulatorsByCpf(cpf)
                .then()
                .extract().path("id");
        SimulatorServices.deleteSimulatorById(id)
                .then()
                .statusCode(SC_OK);
    }

    @ParameterizedTest
    @MethodSource("data.DataProvider#insertInvalidLimitDataProviderSimulator")
    public void insertInvalidLimitValuesSimulations(String cpf, String nome, String email, Integer valor,Integer parcelas, Boolean seguro ){
        HashMap<String,String> requestBody = RequestBuilder.requestBodyPost(cpf, nome, email, valor, parcelas, seguro);
        SimulatorServices.postSimulator(requestBody)
                .then()
                .log().all()
                .statusCode(SC_BAD_REQUEST);
    }

    @ParameterizedTest
    @MethodSource("data.DataProvider#insertDuplicateDataProviderSimulator")
    public void insertDuplicateSimulations(String cpf, String nome, String email, Integer valor,Integer parcelas, Boolean seguro ){
        HashMap<String,String> requestBody = RequestBuilder.requestBodyPost(cpf, nome, email, valor, parcelas, seguro);
        SimulatorServices.postSimulator(requestBody)
                .then()
                .log().all()
                .statusCode(SC_CREATED);
        int id = SimulatorServices.findSimulatorsByCpf(cpf)
                .then()
                .extract().path("id");
        SimulatorServices.postSimulator(requestBody)
                .then()
                .log().all()
                .statusCode(SC_CONFLICT);
        SimulatorServices.deleteSimulatorById(id)
                .then()
                .statusCode(SC_OK);
    }

    @ParameterizedTest
    @MethodSource("data.DataProvider#successDataProviderSimulator")
    public void validateCpfWithSimulators(String cpf,String nome,String email){
        SimulatorServices.findSimulatorsByCpf(cpf)
                .then()
                .statusCode(SC_OK)
                .body("cpf", is(cpf))
                .body("nome", is(nome))
                .body("email", is(email))
        ;

    }

    @ParameterizedTest
    @MethodSource("data.DataProvider#updateDataProviderSimulator")
    public void updateCpfWithSimulators(String cpf, String nome, String email, Integer valor,Integer parcelas, Boolean seguro ){
        HashMap<String,String> requestBody = RequestBuilder.requestBodyPut(cpf, nome, email, valor, parcelas, seguro);
        SimulatorServices.putSimulator(requestBody,cpf)
                .then()
                .log().all()
                .statusCode(SC_OK)
                .body("nome",is(requestBody.get("nome")))
                .body("cpf", is(requestBody.get("cpf")))
                .body("email",is(requestBody.get("email")));
    }

    @ParameterizedTest
    @MethodSource("data.DataProvider#deleteDataProviderSimulator")
    public void recoverIdSimulator(String cpf, String nome, String email, Integer valor,Integer parcelas, Boolean seguro ){
        HashMap<String,String> requestBody = RequestBuilder.requestBodyPost(cpf, nome, email, valor, parcelas, seguro);
        SimulatorServices.postSimulator(requestBody)
                .then()
                .statusCode(SC_CREATED);
        int id = SimulatorServices.findSimulatorsByCpf(cpf)
                .then()
                .extract().path("id");
        SimulatorServices.deleteSimulatorById(id)
                .then()
                .statusCode(SC_OK);
    }

}