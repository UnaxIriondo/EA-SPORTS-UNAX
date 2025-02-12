package CONTROLADOR;

import EXCEPTIONS.DatoNoValido;
import MODELO.Equipo;
import MODELO.EquipoDAO;
import MODELO.tipoEquipo;
import UTILITIS.SolicitarValidarDatos;


import java.lang.classfile.constantpool.StringEntry;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class EquipoController {
    private static EquipoDAO equipoDAO;
    private Scanner sc;

    public EquipoController() {
        this.equipoDAO = new EquipoDAO();// Inicializa el DAO
        this.sc = new Scanner(System.in);
    }

    public static void agregarEquipos(){
        System.out.println("\n--- Agregar Nuevo Equipo ---");

        String nombre = SolicitarValidarDatos.solicitarDato("Nombre", "Ingrese el nombre del equipo: ", "^[A-Za-zÁ-Úá-ú\\s]{2,50}$");
        LocalDate fechaFund = validarFecha("Fecha de fundacion","Teclea la fecha de fundacion del equipo");
        String tipoEquipo = SolicitarValidarDatos.solicitarDato("Tipo de equipo","Teclea el tipo de equipo que seras (Atacante o Defensor)","[Atacante|Defensor]");

        String idEquipo = generarIdAleatorio();

        Equipo equipo = new Equipo(idEquipo,nombre,fechaFund,tipoEquipo,new ArrayList<>(),new ArrayList<>());
        boolean agregado = equipoDAO.agregarEquipo(equipo);
        if (agregado){
            System.out.println("Equipo agregado correctamente");
        }else {
            System.out.println("Error: El equipo ya existe");
        }

    }
    public static  void actualizarDatosEquipo(){

        String idEquipo = SolicitarValidarDatos.solicitarDato("Id Equipo","Teclea el id del equipo","");
        String nombre = SolicitarValidarDatos.solicitarDato("Nombre","Teclea el nombre del equipo","^[A-Z][a-zA-ZñÑ ]{1,19}$");
        LocalDate fechaFund = validarFecha("Fecha de fundacion","Teclea la fecha de fundacion del equipo");
        tipoEquipo tipoEquipo= MODELO.tipoEquipo.valueOf(SolicitarValidarDatos.solicitarDato("Tipo de Equipo","Teclea el tipo de equipo que seras (Atacante o Defensor)","[Atacante|Defensor]"));

    }











    private String generarIdAleatorio() {
        return "E" + (int) (Math.random() * 1000); // Ejemplo: E123
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