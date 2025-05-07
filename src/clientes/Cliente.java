package clientes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Cliente {
    HttpClient client = HttpClient.newHttpClient();
    private final String API_KEY = "452471a859fc1d51c1f7e5c2";

    public double convertirDivisa(String base, String target) {
        Solicitud solicitud = new Solicitud("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + target + "/");

        try {
            HttpResponse<String> response = client
                    .send(solicitud.getRequest(), HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            return jsonObject.get("conversion_rate").getAsDouble();

        } catch (IOException  | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double realizarConversion(double valorConvertido, double valor){
        return valorConvertido * valor;
    }
}







