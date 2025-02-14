package CONTROLADOR;

import EXCEPTIONS.DatoNoValido;
import MODELO.Equipo;
import MODELO.EquipoDAO;
import MODELO.tipoEquipo;
import UTILITIS.CodigoAleatorioUnico;
import UTILITIS.SolicitarValidarDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipoController {
    private static EquipoDAO equipoDAO;
    private Scanner sc;

    public EquipoController() {
        this.equipoDAO = new EquipoDAO();// Inicializa el DAO
        this.sc = new Scanner(System.in);
    }
    public void agregarEquipos(){
        System.out.println("\n--- Agregar Nuevo Equipo ---");

        String nombre = SolicitarValidarDatos.solicitarDato("Nombre", "Ingrese el nombre del equipo: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        LocalDate fechaFund = validarFecha("Fecha de fundacion","Teclea la fecha de fundacion del equipo");
        String tipoStr  = SolicitarValidarDatos.solicitarDato("Tipo de equipo","Teclea el tipo de equipo que seras (Atacante o Defensor)","[Atacante|Defensor]");
        tipoEquipo tipo = tipoEquipo.valueOf(tipoStr.toUpperCase());

        String idEquipo = CodigoAleatorioUnico.generarCodigoUnico();

        Equipo equipo = new Equipo(idEquipo,nombre,fechaFund,tipo ,new ArrayList<>(),new ArrayList<>());
        boolean agregado = equipoDAO.agregarEquipo(equipo);
        if (agregado){
            System.out.println("Equipo agregado correctamente");
        }else {
            System.out.println("Error: El equipo ya existe");
        }
    }
    public void eliminarEquipo(){
        System.out.println("\n--- Eliminar Equipo ---");
        String idEquipo = SolicitarValidarDatos.solicitarDato("ID del Equipo", "Ingrese el ID del equipo a eliminar: ", "");
        boolean eliminado = equipoDAO.eliminarEquipo(idEquipo);
        if (eliminado){
            System.out.println("Equipo eliminado correctamente");
        }else {
            System.out.println("Error: No se encontro el equipo con el ID proporcionado");
        }
    }
    public void modificarEquipo() {
        System.out.println("\n--- Modificar Equipo ---");
        String idEquipo = SolicitarValidarDatos.solicitarDato("ID del Equipo", "Ingrese el ID del equipo a modificar: ", "[0-9]{5}");

        String nuevoNombre = SolicitarValidarDatos.solicitarDato("Nuevo Nombre", "Ingrese el nuevo nombre del equipo: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        LocalDate nuevaFecha = validarFecha("Nueva Fecha de Fundación", "Ingrese la nueva fecha de fundación (dd/MM/yyyy): ");
        String nuevoTipoStr = SolicitarValidarDatos.solicitarDato("Nuevo Tipo de Equipo", "Ingrese el nuevo tipo de equipo (ATACANTE,DEFENSOR): ", "^(PROFESIONAL|AMATEUR|JUVENIL)$");
        tipoEquipo nuevoTipo = tipoEquipo.valueOf(nuevoTipoStr.toUpperCase());

        boolean modificado = equipoDAO.modificarEquipo(idEquipo, nuevoNombre, nuevaFecha, nuevoTipo);
        if (modificado) {
            System.out.println("Equipo modificado correctamente.");
        } else {
            System.out.println("Error: No se encontró el equipo con el ID proporcionado.");
        }
    }

    public void listarEquipos() {
        System.out.println("\n--- Lista de Equipos ---");
        List<Equipo> equipos = equipoDAO.listarEquipos();
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
        } else {
            for (Equipo equipo : equipos) {
                System.out.println(equipo);
            }
        }
    }

    public void agregarJugadoresAEquipos(){

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