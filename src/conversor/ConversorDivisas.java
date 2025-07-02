package conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ConversorDivisas {
    public double convertCurrency(String json, double valor){
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            double valorConvertido = jsonObject.get("conversion_rate").getAsDouble();
            return valorConvertido * valor;
    }
}
