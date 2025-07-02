package clientes;

import conversor.BaseDeMonedas;
import conversor.ConversorDivisas;
import recursos.Recurso;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Cliente {
    private final HttpClient client;
    private final String API_KEY;
    private final BaseDeMonedas baseDeMonedas;
    private final ConversorDivisas conversorDivisas;
    private Historial historial;
    public Cliente() {
        client = HttpClient.newHttpClient();
        API_KEY = "452471a859fc1d51c1f7e5c2";
        baseDeMonedas = new BaseDeMonedas();
        conversorDivisas = new ConversorDivisas();
        historial = new Historial();
    }

    private String request(String base, String target) {
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

    public void realizeSolicited() {
        String baseCode, targetCode;
        double valor;

        System.out.println("Ingrese una divisa como base: ");
        baseCode = Recurso.scanner.nextLine().toUpperCase();
        System.out.println("Ingrese una divisa como target: ");
        targetCode = Recurso.scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el valor a convertir: ");
        valor = Recurso.scanner.nextDouble();

        String jsonString = request(baseCode, targetCode);
        try {
            double valorReal = conversorDivisas.convertCurrency(jsonString, valor);
            System.out.println(valor + " [" + baseCode + "]" + " -> " + valorReal + " [" + targetCode + "]");
            historial.guardarConversion(valor, baseCode, valorReal, targetCode);
        } catch (NullPointerException e) {
            System.out.println("La divisa base o de origen son incorrectas. Puede fijarse en el menu cuales estan disponibles");
            Recurso.scanner.nextLine(); // clean the buffer
        }
    }

    public void mostrarMonedas() {
        baseDeMonedas.show();
    }

    public void showHistorial() {
        historial.show();
    }
}







