package MAIN;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int respuesta = 0;
            boolean cont = true;
            do {
                switch (respuesta) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                           break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("El programa finaliza");
                        break;
                        default: System.out.println("Opcion no existe");
                }
            } while (respuesta != 5);
        } catch (Exception e) {
            System.out.println("Error desconocido en el menu");
        }
    }
}