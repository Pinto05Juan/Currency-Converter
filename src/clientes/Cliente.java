package clientes;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Cliente {
    HttpClient client;
    private final String API_KEY;

    public Cliente() {
        client = HttpClient.newHttpClient();
        API_KEY = "452471a859fc1d51c1f7e5c2";
    }

    public String obtenerSolictud(String base, String target) {
        Solicitud solicitud = new Solicitud
                ("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + target + "/");
        try {
            HttpResponse<String> response = client
                    .send(solicitud.getRequest(), HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException  | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}







