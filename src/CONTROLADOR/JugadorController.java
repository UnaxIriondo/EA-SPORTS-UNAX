package CONTROLADOR;

import EXCEPTIONS.DatoNoValido;
import MODELO.*;
import UTILITIS.SolicitarValidarDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class JugadorController {
    private static JugadorDAO jugadorDAO;
    private static Scanner sc;
    private static EquipoDAO equipoDAO;
    private static Jugador jugador;

    // Constructor
    public JugadorController() {
        this.jugadorDAO = new JugadorDAO();
        this.sc = new Scanner(System.in);
    }
    public JugadorController(EquipoDAO equipoDAO) {
        this.jugadorDAO = new JugadorDAO();
        this.equipoDAO = equipoDAO; // Inicializar el EquipoDAO
        this.sc = new Scanner(System.in);
    }

    // Mét0do para agregar un jugador
    public static Jugador agregarJugador(Equipo equipo) {
        System.out.println("\n--- Agregar Nuevo Jugador ---");

        String idJugador = SolicitarValidarDatos.solicitarDato("ID del Jugador", "Ingrese el ID del jugador: ", "^[A-Za-z0-9]{1,10}$");
        String nombre = SolicitarValidarDatos.solicitarDato("Nombre", "Ingrese el nombre del jugador: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        String apellido = SolicitarValidarDatos.solicitarDato("Apellido", "Ingrese el apellido del jugador: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        String nacionalidad = SolicitarValidarDatos.solicitarDato("Nacionalidad", "Ingrese la nacionalidad del jugador: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        LocalDate fechaNac = validarFecha("Fecha de Nacimiento", "Ingrese la fecha de nacimiento (dd/MM/yyyy): ");
        double sueldo = Double.parseDouble(SolicitarValidarDatos.solicitarDato("Sueldo", "Ingrese el sueldo del jugador: ", "^[0-9]+(\\.[0-9]{1,2})?$"));

        String rolStr  = SolicitarValidarDatos.solicitarDato("Rol de valorant","Teclea el rol que seras (duelista,centinela,controlador,iniciador)","[duelista|centinela|controlador|iniciador]").toLowerCase();
        Roles rol = new Roles(RolesDAO.obtenerRoles());



        System.out.println("\nSeleccione un equipo:");
        equipo = seleccionarEquipo();
        if (equipo == null) {
            System.out.println("No se pudo asignar un equipo.");
            agregarJugador(equipo);
        }
        if (equipo.getListaJugadores().size() >= 6) {
            System.out.println("Error: Este equipo ya tiene el máximo de 6 jugadores.");
            agregarJugador(equipo);
        }
        if (!rol.getRolesValorant().contains(rolStr)){
            System.out.println("Error: Rol no encontrado");
            agregarJugador(equipo);
        }
        jugador = new Jugador(idJugador, nombre, apellido, nacionalidad, fechaNac, sueldo, equipo, rol);
        boolean agregado = jugadorDAO.agregarJugador(jugador);

        if (agregado) {
            equipo.agregarJugador(jugador);
            System.out.println("Jugador agregado correctamente.");
        } else {
            System.out.println("Error: El jugador ya existe.");
        }
        return jugador;
    }

    // Mét0do para eliminar un jugador
    public static Jugador eliminarJugador() {
        System.out.println("\n--- Eliminar Jugador ---");
        String idJugador = SolicitarValidarDatos.solicitarDato("ID del Jugador", "Ingrese el ID del jugador a eliminar: ", "^[A-Za-z0-9]{1,10}$");

        boolean eliminado = jugadorDAO.eliminarJugador(idJugador);
        if (eliminado) {
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("Error: No se encontró el jugador con el ID proporcionado.");
        }

        eliminado = jugadorDAO.eliminarJugador(idJugador);
        if (eliminado) {
            jugador.getEquipo().eliminarJugador(jugador); // Eliminar el jugador del equipo
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("Error: No se pudo eliminar el jugador.");
        }
        return jugador;
    }

    // Mét0do para modificar un jugador
    public static Jugador modificarJugador() {
        System.out.println("\n--- Modificar Jugador ---");
        String idJugador = SolicitarValidarDatos.solicitarDato("ID del Jugador", "Ingrese el ID del jugador a modificar: ", "^[A-Za-z0-9]{1,10}$");

        String nuevoNombre = SolicitarValidarDatos.solicitarDato("Nuevo Nombre", "Ingrese el nuevo nombre del jugador: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        String nuevoApellido = SolicitarValidarDatos.solicitarDato("Nuevo Apellido", "Ingrese el nuevo apellido del jugador: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        String nuevaNacionalidad =SolicitarValidarDatos.solicitarDato("Nueva Nacionalidad", "Ingrese la nueva nacionalidad del jugador: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        LocalDate nuevaFechaNac = validarFecha("Nueva Fecha de Nacimiento", "Ingrese la nueva fecha de nacimiento (dd/MM/yyyy): ");
        double nuevoSueldo = Double.parseDouble(SolicitarValidarDatos.solicitarDato("Nuevo Sueldo", "Ingrese el nuevo sueldo del jugador: ", "^[0-9]+(\\.[0-9]{1,2})?$"));

        System.out.print("Ingrese el nuevo ID del equipo: ");
        String nuevoIdEquipo = sc.nextLine();
        Equipo nuevoEquipo = seleccionarEquipo();
        if (nuevoEquipo == null) {
            System.out.println("No se pudo asignar un equipo al jugador.");
            modificarJugador();
        }

        String nuevoRolStr = SolicitarValidarDatos.solicitarDato("Rol de valorant","Teclea el rol que seras (duelista,centinela,controlador,iniciador)","[duelista|centinela|controlador|iniciador]").toLowerCase();
        Roles rol = new Roles(RolesDAO.obtenerRoles());
        if (!rol.getRolesValorant().contains(nuevoRolStr)){
            System.out.println("Error: Rol no encontrado");
            modificarJugador();
        }
        boolean modificado = jugadorDAO.modificarJugador(idJugador, nuevoNombre, nuevoApellido, nuevaNacionalidad, nuevaFechaNac, nuevoSueldo, nuevoEquipo, rol);
        if (modificado) {
            System.out.println("Jugador modificado correctamente.");
        } else {
            System.out.println("Error: No se encontró el jugador con el ID proporcionado.");
        }
        return jugador;
    }

    // Mét0do para listar todos los jugadores
    public static void listarJugadores() {
        System.out.println("\n--- Lista de Jugadores ---");
        List<Jugador> jugadores = jugadorDAO.listarJugadores();
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    //Método para seleccionar un equipo
    private static Equipo seleccionarEquipo() {
        System.out.println("\n--- Seleccionar Equipo ---");
        List<Equipo> equipos = equipoDAO.listarEquipos();
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
            return null;
        }

        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }

        System.out.print("Seleccione el número del equipo: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion < 1 || opcion > equipos.size()) {
            System.out.println("Opción no válida.");
            return null;
        }

        return equipos.get(opcion - 1); // Te devuelve el equipo selec
    }

    public static LocalDate validarFecha(String dato, String mensaje){
        Scanner sc = new Scanner(System.in);
        boolean error = true;
        LocalDate fecha = null;
        String fecha_salida= "";
        while (error)
        {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.print(mensaje);

                fecha_salida = sc.nextLine();
                if (fecha_salida.isEmpty()){
                    throw new DatoNoValido(dato + " es un campo obligatorio");
                }
                fecha = LocalDate.parse(fecha_salida, formatter);
                error = false;
            } catch (DatoNoValido e) {
                System.out.println(e.getMessage());

            }catch (DateTimeParseException e){
                System.out.println(dato + " no tiene un formato adedcuado");
            }
        }
        return fecha;
    }
}