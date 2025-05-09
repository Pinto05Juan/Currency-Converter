import clientes.Cliente;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al Convertir de Monedas");
        Cliente client = new Cliente();
        boolean salir = false;


        while (!salir){
            mostrarMenu();
            System.out.println("Elija una opcion valida: ");
            int numero = scan.nextInt();
            double valor;
            double valorConvertido;
            double valorReal;
            switch (numero) {
                case 1:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = scan.nextDouble();
                    //System.out.println("El valor " + valor + " USD" + " corresponde al valor final de " + valorReal + " ARS");
                    break;
                case 2:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = scan.nextDouble();
                    //System.out.println("El valor " + valor + " ARS" + " corresponde al valor final de " + valorReal + " USD");
                    break;
                case 3:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = scan.nextDouble();
                    //System.out.println("El valor " + valor + " USD" + " corresponde al valor final de " + valorReal + " BRL");
                    break;
                case 4:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = scan.nextDouble();
                    //System.out.println("El valor " + valor + " BRL" + " corresponde al valor final de " + valorReal + " USD");
                    break;
                case 5:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = scan.nextDouble();
                    //System.out.println("El valor " + valor + " USD" + " corresponde al valor final de " + valorReal + " COP");
                    break;
                case 6:
                    System.out.println("Ingrese el valor que desea convertir: ");
                    valor = scan.nextDouble();
                    //System.out.println("El valor " + valor + " COP" + " corresponde al valor final de " + valorReal + " USD");
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }

        System.out.println("Fin del programa");

    }

    public static void mostrarMenu() {
        System.out.println("""
                1) Dolar -> Peso argentino
                2) Peso argentino -> Dolar
                3) Dolar -> Real brasileño
                4) Real brasileño -> Dolar
                5) Dolar -> Peso colombiano
                6) Peso colombiano -> Dolar
                7) Salir
                """);
    }
}
