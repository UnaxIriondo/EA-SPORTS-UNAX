package VISTA;
import UTILITIS.SolicitarValidarDatos;

public class Menus {

    public static String menuCompeticion(){
        System.out.println("---MENU COMPETICION---");
        System.out.println("1. Abrir fase de inscripcion");
        System.out.println("2. Salir del programa\n");

        String opcion = SolicitarValidarDatos.solicitarDato("Opción","Introduza la Opcion que desea ejecutar","[1|2]");

        return opcion;
    }

    public static String menuEquipo(){
        System.out.println("---MENU EQUIPO---");
        System.out.println("1. Inscribir equipo");
        System.out.println("2. Modificar equipo");
        System.out.println("3. Eliminar equipo");
        System.out.println("4. Mostrar equipos");
        System.out.println("5. Mostar equipo");

        String opcion = SolicitarValidarDatos.solicitarDato("Opción","Introduza la Opcion que desea ejecutar","[1|2|3|4|5]");

        return opcion;
    }

    public static String menuJugador(){
        System.out.println("---MENU JUGADOR---");
        System.out.println("1. Inscribir Jugador");
        System.out.println("2. Modificar Jugador");
        System.out.println("3. Eliminar Jugador");
        System.out.println("4. Mostrar Jugadors");
        System.out.println("5. Mostar Jugador");

        String opcion = SolicitarValidarDatos.solicitarDato("Opción","Introduza la Opcion que desea ejecutar","[1|2|3|4|5]");

        return opcion;
    }

    public static void menuJornada(){
        System.out.println("---MENU JORNADA---");
        System.out.println("1. Crear Jornada");
    }

}
