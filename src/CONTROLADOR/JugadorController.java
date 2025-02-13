package CONTROLADOR;

import EXCEPTIONS.DatoNoValido;
import MODELO.tipoEquipo;
import UTILITIS.SolicitarValidarDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class JugadorController {
    public JugadorController() {
        this.listajugadores = new ArrayList();
    }

    public static void agregarJugadores(){

    }
    public static  void actualizarDatosJugador(){

        String idEquipo = SolicitarValidarDatos.solicitarDato("Id Jugador","Teclea el id del jugador","");
        String nombre = SolicitarValidarDatos.solicitarDato("Nombre","Teclea el nombre del jugador","^[A-Z][a-zA-ZñÑ ]{1,19}$");
        String apellido = SolicitarValidarDatos.solicitarDato("Apellido","Teclea el apellido del jugador","^[A-Z][a-zA-ZñÑ ]{1,19}$");
        String nacionalidad = SolicitarValidarDatos.solicitarDato("Nacionalidad","Teclea la nacionalidad del jugador","");
        LocalDate fechaFund = LocalDate.parse(SolicitarValidarDatos.solicitarDato("Fecha de fundacion","Teclea la fecha de fundacion del equipo",""));
        tipoEquipo tipoEquipo= MODELO.tipoEquipo.valueOf(SolicitarValidarDatos.solicitarDato("Tipo de Equipo","Teclea el tipo de equipo que seras (Atacante o Defensor)","[Atacante|Defensor]"));
     
        String nacionalidades = local.getDisplayCountry(); //para lo de las nacionalidades
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
