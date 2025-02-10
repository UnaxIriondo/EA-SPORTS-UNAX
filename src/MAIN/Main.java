package MAIN;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String texto = "Cargando";
        int repeticiones = 5;

        for (int i = 0; i < repeticiones; i++) {
            try {
                for (int puntos = 1; puntos <= 3; puntos++) {
                    System.out.print("\r" + texto + ".".repeat(puntos)); // Muestra de 1 a 3 puntos
                    Thread.sleep(300); // Pausa de 300 ms entre cada cambio de puntos
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Borra el mensaje de carga
        System.out.print("\r" + " ".repeat(texto.length() + 3) + "\r"); // Borra la línea con espacios

        Scanner sc = new Scanner(System.in);
        StringBuilder informacionCompleta = new StringBuilder();

        String opcion;
        Matcher matcher;
        do {

            boolean hasta = true;
            String opcionBien = "";
            do {
                System.out.println("Bienvenido a E-Sports");
                System.out.println("\n-- Menú de Inicio --");
                System.out.println("1) Registrar Equipo");
                System.out.println("2) Registrar Jornada");
                System.out.println("3) Registrar Enfrentamiento");
                System.out.println("4) Mostrar Informacion");
                System.out.println("5) Salir");
                System.out.print("Opcion: ");
                opcion = sc.nextLine();
                opcionBien = "";
                Pattern patron = Pattern.compile("^(1|2|3|4)$");
                matcher = patron.matcher(opcion);
                if (matcher.matches()) {
                    opcionBien = opcion;
                    hasta = false;
                } else {
                    System.out.println("\nERROR. Opción no valida.\n");
                }
            } while (hasta);


            switch (opcion) {
                case "1":
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
            }
        }while (!opcion.equals("5"));

    }
}