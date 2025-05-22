package clientes;

import conversor.BaseDeMonedas;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Cliente {
    private HttpClient client;
    private final String API_KEY;
    private BaseDeMonedas baseDeMonedas;
    public Cliente() {
        client = HttpClient.newHttpClient();
        API_KEY = "452471a859fc1d51c1f7e5c2";
        baseDeMonedas = new BaseDeMonedas();
    }

    public String request(String base, String target) {
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

    public void realizarSolicitud() {
        String baseCode;
        String targetCode;
        int value;

        System.out.println("Ingrese la divisa de origen ");

    }

    public void mostrarMonedas() {
        baseDeMonedas.mostrarMonedas();
    }

}







