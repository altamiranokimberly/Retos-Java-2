import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Sucursal sucursal1 = new Sucursal("Centro", Arrays.asList(
                new Encuesta("Ana", "Muy lento el servicio", 2),
                new Encuesta("Luis", null, 3),
                new Encuesta("Marta", "Recepcionista grosera", 1),
                new Encuesta("Carlos", null, 5)
        ));

        Sucursal sucursal2 = new Sucursal("Norte", Arrays.asList(
                new Encuesta("Pedro", null, 2),
                new Encuesta("Laura", "No había médico disponible", 3),
                new Encuesta("Jorge", "Instalaciones sucias", 2),
                new Encuesta("Lucía", null, 4)
        ));

        List<Sucursal> sucursales = Arrays.asList(sucursal1, sucursal2);

        // Procesamiento con Stream API y flatMap
        List<String> mensajesSeguimiento = sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(encuesta -> encuesta.getCalificacion() <= 3)
                                .flatMap(encuesta ->
                                        encuesta.getComentario()
                                                .map(comentario ->
                                                        "Sucursal [" + sucursal.getNombre() + "]: Seguimiento a paciente con comentario: \"" + comentario + "\""
                                                )
                                                .stream()
                                )
                )
                .toList();

        mensajesSeguimiento.forEach(System.out::println);
    }
}
