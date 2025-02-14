package MAIN;

import CONTROLADOR.CompeticionController;
import CONTROLADOR.EquipoController;
import CONTROLADOR.JornadaController;
import CONTROLADOR.JugadorController;
import MODELO.Competicion;
import MODELO.Equipo;
import MODELO.Jornada;
import MODELO.Jugador;
import UTILITIS.CodigoAleatorioUnico;
import VISTA.Menus;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static List<Competicion> listaCompeticiones = new ArrayList<>();
    private static List<Equipo> listaEquipos = new ArrayList<>();
    private static List<Jugador> listaJugadores = new ArrayList<>();
    private static List<Jornada> listaJornadas = new ArrayList<>();

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
                        break;
                    case "4":
                        menuEnfrentamiento();
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
                        listaEquipos.add(EquipoController.modificarEquipo());
                        break;
                    case "3":
                        //ELIMINAR EQUIPO
                        listaEquipos.remove(EquipoController.eliminarEquipo());
                        break;
                    case "4":
                        //LISTAR EQUIPO
                        System.out.println(listaEquipos);
                    case "6":
                        //VOLVER AL MENU PRINCIPAL
                        menuPrincipal();
                        break;
                    case "7":
                        //SALIR
                        System.exit(0);
                        break;
                }
            }while(!respuesta.equals("7"));
        } catch (Exception e) {
            System.out.println("Error desconocido en el menu."+e.getMessage());
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
                        listaJugadores.add(JugadorController.agregarJugador(listaEquipos.get(0)));
                        break;
                    case "2":
                        //MODIFICAR JUGADOR
                        listaJugadores.add(JugadorController.modificarJugador());
                        break;
                    case "3":
                        //ELIMINAR JUGADOR
                        listaJugadores.remove(JugadorController.eliminarJugador());
                        break;
                    case "4":
                        JugadorController.listarJugadores();
                    case "6":
                        //VOLVER AL MENU PRINCIPAL
                        menuPrincipal();
                        break;
                    case "7":
                        //SALIR
                        System.exit(0);
                        break;
                }
            }while(!respuesta.equals("7"));
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
                        //CREAR JORNADA
                        //listaJornadas.add(JornadaController.crearJornada());
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
            }while(!respuesta.equals("3"));
        } catch (Exception e) {
            System.out.println("Error desconocido en el menu.");
        }
    }
    public static void menuEnfrentamiento(){
        String respuesta;

    }
}