package MAIN;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int respuesta;
            boolean cont = true;
            do {
                System.out.println("""
                 --Bienvenido a EA-SPORTS--
                 ===MENU DE INICIO===
                 1.Registrar Equipo
                 2.Registrar Jornada
                 3.Registrar Enfrentamiento
                 4.Mostrar Informacion
                 5.Salir del programa
                        
                Teclea la opción deseada:""");

                respuesta = scanner.nextInt();

                switch (respuesta) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
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
