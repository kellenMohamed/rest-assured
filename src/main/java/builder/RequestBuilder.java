package builder;

import java.util.HashMap;

public class RequestBuilder {
    public static HashMap<String, String> requestBodyPost(String cpf, String nome, String email, Integer valor,Integer parcelas, Boolean seguro ){
        HashMap<String,String>body= new HashMap<>();
        body.put("nome", nome);
        body.put("cpf",cpf);
        body.put("email",email);
        body.put("valor",valor.toString());
        body.put("parcelas",parcelas.toString());
        body.put("seguro",seguro.toString());

        return body;
    }

    public static HashMap<String, String> requestBodyPut(String cpf, String nome, String email, Integer valor,Integer parcelas, Boolean seguro ){
        HashMap<String,String>body= new HashMap<>();
        body.put("nome", nome);
        body.put("cpf",cpf);
        body.put("email",email);
        body.put("valor",valor.toString());
        body.put("parcelas",parcelas.toString());
        body.put("seguro",seguro.toString());

        return body;
    }
}
