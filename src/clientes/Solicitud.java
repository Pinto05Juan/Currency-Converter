package clientes;

import java.net.URI;
import java.net.http.HttpRequest;

public class Solicitud {

    private HttpRequest request;

    public Solicitud(String direccion) {
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
    }

    public HttpRequest getRequest() {
        return this.request;
    }
}
