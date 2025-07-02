package clientes;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historial {
    private final String archivo = "historial.txt";

    public void guardarConversion(double valor, String baseCode, double valorConvertido, String targetCode) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("HH:mm a - dd/MM/yyyy");
        String line = String.format("%s - %.2f [%s] -> %.2f [%s]",
                now.format(formatoFecha), valor, baseCode, valorConvertido, targetCode);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(archivo, true))){
            printWriter.println(line);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void show() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el historial: " + e.getMessage());
        }
    }
}
