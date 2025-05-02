package clientes;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Cliente {
    HttpClient client = HttpClient.newHttpClient();
    private final String API_KEY = "452471a859fc1d51c1f7e5c2";

    public double convertirDivisa(double valor, String base, String target) {
        Solicitud solicitud = new Solicitud("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + base + "/" + target + "/");

        try {
            HttpResponse<String> response = client
                    .send(solicitud.getRequest(), HttpResponse.BodyHandlers.ofString());

        } catch (IOException  | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return valor;
    }


    public String getAPI_KEY() {
        return API_KEY;
    }
}







