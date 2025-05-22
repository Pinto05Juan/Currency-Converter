package principal;

import clientes.Cliente;
import conversor.ConversorDivisas;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al Convertir de Monedas");
        Cliente client = new Cliente();
        ConversorDivisas conversorDivisas = new ConversorDivisas();
        boolean finProgram = false;


        while (!finProgram){
            mostrarMenu();
            System.out.println("Seleccione una opcion: ");
            int option = scan.nextInt();

            switch (option) {
                case 1:
                    client.mostrarMonedas();
                    break;
                case 2:
                    //client.realizarSolicitud();
                    break;
                case 3:
                    //client.mostrarHistorial();
                    break;
                case 4:
                    finProgram = true;
                    break;
                default:
                    System.out.println("Su opcion no es valida. Ingrese de nuevo");
                    break;
            }
        }

        System.out.println("Fin del programa");

    }

    public static void mostrarMenu() {
        System.out.println("""
                1) Mostrar Monedas Disponibles
                2) Conversion
                3) Historial de Conversiones
                4) Salir
                """);
    }
}
