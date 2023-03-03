package tests;

import base.Base;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import services.RestrictionServices;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

public class RestrictionTest extends Base {

    @ParameterizedTest
    @MethodSource("data.DataProvider#successDataProviderRestriction")
    public void validateCpfWithRestriction(String cpfRestriction){
        RestrictionServices.findRestrictionbyCpf(cpfRestriction)
                .then()
                .statusCode(SC_OK)
                .body("mensagem", is("O CPF " + cpfRestriction + " possui restrição"));
    }

    @ParameterizedTest
    @MethodSource("data.DataProvider#successDataProviderWithoutRestriction")
    public void validateCpfWithoutRestriction(String cpfWithoutRestriction){
        RestrictionServices.findRestrictionbyCpf(cpfWithoutRestriction)
                .then()
                .statusCode(SC_NO_CONTENT);
    }
}
