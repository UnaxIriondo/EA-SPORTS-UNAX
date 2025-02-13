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

    public static String menuPrincipal(){
        System.out.println("---MENU PRINCIPAL---");
        System.out.println("1. Gestionar Equipos");
        System.out.println("2. Gestionar Jugadores");
        System.out.println("3. Gestionar Jornadas");
        System.out.println("4. Gestionar Enfrentamientos");
        System.out.println("5. Salir del programa");

        String opcion = SolicitarValidarDatos.solicitarDato("Opción","Introduza la Opcion que desea ejecutar","[1|2|3|4|5]");

        return opcion;
    }

    public static String menuEquipo(){
        System.out.println("---MENU EQUIPO---");
        System.out.println("1. Inscribir equipo");
        System.out.println("2. Modificar equipo");
        System.out.println("3. Eliminar equipo");
        System.out.println("4. Mostrar equipos");
        System.out.println("5. Mostar equipo");

        String opcion = SolicitarValidarDatos.solicitarDato("Opción","Introduza la Opcion que desea ejecutar","[1|2|3|4|5|6|7]");

        return opcion;
    }

    public static String menuJugador(){
        System.out.println("---MENU JUGADOR---");
        System.out.println("1. Inscribir Jugador");
        System.out.println("2. Modificar Jugador");
        System.out.println("3. Eliminar Jugador");
        System.out.println("4. Mostrar Jugadors");
        System.out.println("5. Mostar Jugador");
        System.out.println("6. Salir al menu principal");
        System.out.println("7. Salir del programa");

        String opcion = SolicitarValidarDatos.solicitarDato("Opción","Introduza la Opcion que desea ejecutar","[1|2|3|4|5|6|7]");

        return opcion;
    }

    public static String menuJornada(){
        System.out.println("---MENU JORNADA---");
        System.out.println("1. Crear Jornada");
        System.out.println("2. Salir al menu principal");
        System.out.println("3. Salir del programa");
        String opcion = SolicitarValidarDatos.solicitarDato("Opción","Introduza la Opcion que desea ejecutar","[1|2|3]");

        return opcion;
    }

}
