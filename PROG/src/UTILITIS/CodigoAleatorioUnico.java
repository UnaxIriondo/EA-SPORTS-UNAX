package UTILITIS;
import java.util.*;

public class CodigoAleatorioUnico {
    private static final int tamanio = 5;
    private static final List<String> codigos = new ArrayList<>();
    public static String generarCodigo() {
        String nuevoCodigo = generarCodigoUnico();

        return nuevoCodigo;
    }

    public static String generarCodigoUnico() {
        Random random = new Random();
        String nuevoCodigo;

        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tamanio; i++) {
                sb.append(random.nextInt(10)); // Generar número entre 0 y 9
            }
            nuevoCodigo = sb.toString();
        } while (codigos.contains(nuevoCodigo)); // Asegurar que no se repita ningún código anterior

        codigos.add(nuevoCodigo); // Guardar el nuevo código generado
        return nuevoCodigo;
    }
}
