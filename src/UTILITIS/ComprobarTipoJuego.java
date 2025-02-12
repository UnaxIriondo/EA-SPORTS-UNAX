package UTILITIS;

import EXCEPTIONS.TipoJuegoException;
import MODELO.tipoJuego;

public class ComprobarTipoJuego {

    public static tipoJuego comprobarTipoJuego(String juego) {
        boolean encontrado = false;
        do {
            try {
                juego = SolicitarValidarDatos.solicitarDato("Juego","Ingrese el nombre del juego","[A-Za-z]+").toLowerCase();

                for (tipoJuego tipo : tipoJuego.values()) {
                    if (tipo.name().equals(juego)){
                        juego = tipo.name();
                        encontrado = true;
                    }
                    else{
                        encontrado = false;
                        throw new TipoJuegoException();
                    }
                }
            }catch (TipoJuegoException e){
                System.out.println(e.getMessage());
            }
        }while (!encontrado);
        return tipoJuego.valueOf(juego);
    }
}
