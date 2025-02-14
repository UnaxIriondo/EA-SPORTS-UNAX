package CONTROLADOR;

import MODELO.Jornada;
import UTILITIS.SolicitarValidarDatos;

import java.time.LocalDate;
import java.util.ArrayList;

import static MODELO.JornadaDAO.*;

public class JornadaController {
    public static void crearJornada(ArrayList<Jornada> listaJornadas) {
        String numJornada = SolicitarValidarDatos.solicitarDato("Número de Jornada", "Teclea el número de la jornada", "\\d+");
        LocalDate fechaInicio = LocalDate.parse(SolicitarValidarDatos.solicitarDato("Fecha de Inicio", "Teclea la fecha de inicio (YYYY-MM-DD)", "\\d{4}-\\d{2}-\\d{2}"));
        insertarJornada(listaJornadas, numJornada, fechaInicio);
    }

    public static void mostrarJornada(ArrayList<Jornada> listaJornadas) {
        String idJornada = SolicitarValidarDatos.solicitarDato("ID Jornada", "Teclea el ID de la jornada a mostrar", "\\d+");
        mostrarJornadaDAO(listaJornadas, idJornada);
    }

    public static void mostrarJornadas(ArrayList<Jornada> listaJornadas) {
        mostrarJornadasDAO(listaJornadas);
    }
}
