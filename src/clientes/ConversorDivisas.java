package clientes;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class ConversorDivisas {
    private Map<Integer, String> mapaDivisa = new HashMap<>();
    Cliente client = new Cliente();

    public double ConvertirDivisa(String json, double valor){
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double valorConvertido = jsonObject.get("conversion_rate").getAsDouble();
        return valorConvertido * valor;
    }
}
