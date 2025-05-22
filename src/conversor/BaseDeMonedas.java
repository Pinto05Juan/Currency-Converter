package conversor;

import java.util.HashMap;

public class BaseDeMonedas {
    private HashMap<String, String> currencies;

    public BaseDeMonedas() {
        currencies = new HashMap<>();
        cargarBase();
    }

    public void cargarBase() {
        currencies.put("ARS", "ARGENTINA");
        currencies.put("BOB", "BOLIVIA");
        currencies.put("BRL", "BRASIL");
        currencies.put("CAD", "CANADA");
        currencies.put("CLP", "CHILE");
        currencies.put("COP", "COLOMBIA");
        currencies.put("GBP", "REINO UNIDO");
        currencies.put("MEX", "MEXICO");
        currencies.put("PER", "PERU");
        currencies.put("PYG", "PARAGUAY");
        currencies.put("UYU", "URUGUAY");
        currencies.put("VES", "VENEZUELA");
        currencies.put("EUR", "EUROPA");
        currencies.put("CHF", "SUIZA");
        currencies.put("USD", "ESTADOS UNIDOS");
    }

    public void cargarNuevaMoneda(String baseCode, String country) {
        currencies.put(baseCode, country);
    }

    public void mostrarMonedas() {
        currencies.forEach((codigo, pais) ->
                System.out.println(codigo + " -> " + pais));
    }
}
