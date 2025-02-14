package MAIN;

import CONTROLADOR.CompeticionController;
import CONTROLADOR.EquipoController;
import MODELO.Competicion;
import MODELO.Equipo;
import VISTA.Menus;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static List<Competicion> listaCompeticiones = new ArrayList<>();
    private static List<Equipo> listaEquipos = new ArrayList<>();

    public static void main(String[] args) {
        String respuesta = Menus.menuCompeticion();
        try {
            while (!respuesta.equals("2")) {
                switch (respuesta) {
                    case "1":
                        listaCompeticiones.add(CompeticionController.abrirCompeticion());
                        menuPrincipal();
                        break;
                    case "2":
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error desconocido en el menu.");
        }
    }

    public static void menuPrincipal() {
        String respuesta = Menus.menuPrincipal();
        try {
            while (!respuesta.equals("2")) {
                switch (respuesta) {
                    case "1":
                        menuEquipo();
                        break;
                    case "2":
                        menuJugador();
                        break;
                    case "3":
                        menuJornada();
                    case "5":
                        //SALIR
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("Error desconocido en el menu.");
        }
    }

    public static void menuEquipo() {
        String respuesta;
        try {
            do {
                respuesta = Menus.menuEquipo();
                switch (respuesta) {
                    case "1":
                        //CREAR EQUIPO
                        listaEquipos.add(EquipoController.agregarEquipos());
                        break;
                    case "2":
                        //MODIFICAR EQUIPO
                        listaEquipos.add(EquipoController.modificarEquipos());
                        break;
                    case "3":
                        //ELIMINAR EQUIPO
                        listaEquipos.add(EquipoController.eliminarEquipo());
                        break;
                    case "6":
                        //VOLVER AL MENU PRINCIPAL
                        menuPrincipal();
                        break;
                    case "7":
                        //SALIR
                        System.exit(0);
                        break;
                }
            }while(!respuesta.equals("2"));
        } catch (Exception e) {
            System.out.println("Error desconocido en el menu.");
        }
    }

    public static void menuJugador() {
        String respuesta;
        try {
            do {
                respuesta = Menus.menuJugador();
                switch (respuesta) {
                    case "1":
                        //CREAR JUGADOR
                        break;
                    case "2":
                        //MODIFICAR JUGADOR
                        break;
                    case "3":
                        //ELIMINAR JUGADOR
                        break;
                    case "6":
                        //VOLVER AL MENU PRINCIPAL
                        menuPrincipal();
                        break;
                    case "7":
                        //SALIR
                        System.exit(0);
                        break;
                }
            }while(!respuesta.equals("2"));
        } catch (Exception e) {
            System.out.println("Error desconocido en el menu.");
        }
    }

    public static void menuJornada(){
        String respuesta;
        try {
            do {
                respuesta = Menus.menuJornada();
                switch (respuesta) {
                    case "1":
                        break;
                    case "2":
                        //VOLVER AL MENU PRINCIPAL
                        menuPrincipal();
                        break;
                    case "3":
                        //SALIR
                        System.exit(0);
                        break;
                }
            }while(!respuesta.equals("2"));
        } catch (Exception e) {
            System.out.println("Error desconocido en el menu.");
        }
    }
}