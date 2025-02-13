package CONTROLADOR;

import EXCEPTIONS.DatoNoValido;
import MODELO.tipoEquipo;
import UTILITIS.SolicitarValidarDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class JugadorController {
    private JugadorDAO jugadorDAO;
    private Scanner sc;
    private EquipoDAO equipoDAO;

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
    public void agregarJugador() {
        System.out.println("\n--- Agregar Nuevo Jugador ---");

        String idJugador = SolicitarValidarDatos.solicitarDato("ID del Jugador", "Ingrese el ID del jugador: ", "^[A-Za-z0-9]{1,10}$");
        String nombre = SolicitarValidarDatos.solicitarDato("Nombre", "Ingrese el nombre del jugador: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        String apellido = SolicitarValidarDatos.solicitarDato("Apellido", "Ingrese el apellido del jugador: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        String nacionalidad = SolicitarValidarDatos.solicitarDato("Nacionalidad", "Ingrese la nacionalidad del jugador: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        LocalDate fechaNac = validarFecha("Fecha de Nacimiento", "Ingrese la fecha de nacimiento (dd/MM/yyyy): ");
        double sueldo = Double.parseDouble(SolicitarValidarDatos.solicitarDato("Sueldo", "Ingrese el sueldo del jugador: ", "^[0-9]+(\\.[0-9]{1,2})?$"));

        System.out.print("Ingrese el ID del equipo: ");
        String idEquipo = sc.nextLine();
        Equipo equipo = seleccionarEquipo();
        if (equipo == null) {
            System.out.println("No se pudo asignar un equipo al jugador.");
            return;
        }

        String rolStr  = SolicitarValidarDatos.solicitarDato("Rol de valorant","Teclea el rol que seras (duelista,centinela,controlador,iniciador)","[duelista|centinela|controlador|iniciador]");
        rolesValorant rol = rolesValorant.valueOf(rolStr.toLowerCase());

        Jugador jugador = new Jugador(idJugador, nombre, apellido, nacionalidad, fechaNac, sueldo, equipo, rol);
        boolean agregado = jugadorDAO.agregarJugador(jugador);

        if (agregado) {
            System.out.println("Jugador agregado correctamente.");
        } else {
            System.out.println("Error: El jugador ya existe.");
        }

        listaJugadores.add(jugador);

    }

    // Mét0do para eliminar un jugador
    public void eliminarJugador() {
        System.out.println("\n--- Eliminar Jugador ---");
        String idJugador = SolicitarValidarDatos.solicitarDato("ID del Jugador", "Ingrese el ID del jugador a eliminar: ", "^[A-Za-z0-9]{1,10}$");

        boolean eliminado = jugadorDAO.eliminarJugador(idJugador);
        if (eliminado) {
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("Error: No se encontró el jugador con el ID proporcionado.");
        }
        listajugadores.remove(jugador);
    }

    // Mét0do para modificar un jugador
    public void modificarJugador() {
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
            return;
        }

        System.out.print("Ingrese el nuevo rol del jugador (JUGADOR, ENTRENADOR, ASISTENTE): ");
        String nuevoRolStr = sc.nextLine().toUpperCase();
        rolesValorant nuevoRol = rolesValorant.valueOf(nuevoRolStr);

        boolean modificado = jugadorDAO.modificarJugador(idJugador, nuevoNombre, nuevoApellido, nuevaNacionalidad, nuevaFechaNac, nuevoSueldo, nuevoEquipo, nuevoRol);
        if (modificado) {
            System.out.println("Jugador modificado correctamente.");
        } else {
            System.out.println("Error: No se encontró el jugador con el ID proporcionado.");
        }
    }

    // Mét0do para listar todos los jugadores
    public void listarJugadores() {
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
    private Equipo seleccionarEquipo() {
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
