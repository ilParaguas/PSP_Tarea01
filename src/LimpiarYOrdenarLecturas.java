
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LimpiarYOrdenarLecturas {

    @SuppressWarnings("FieldMayBeFinal")
    // Elijo arrayList sobre linkedList porque es más óptimo para recorrer todos los elementos
    private static List<Lectura> lecturasValidas = new ArrayList<>();

    public static void main(String[] args) {
        // Abro canal de entrada de datos
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;
            // Lectura de entrada de datos STDIN de las lecturas generadas por la clase SimularLecturas
            while ((linea = br.readLine()) != null) {
                String regex = "[;]";
                String[] datos = linea.split(regex);

                // Descarto lecturas mal formadas
                if (datos.length == 3
                        && Double.compare(Double.parseDouble(datos[2]), -20) > 0
                        && Double.compare(Double.parseDouble(datos[2]), 60) < 0) {
                    lecturasValidas.add(new Lectura(datos[0], datos[1], Double.parseDouble(datos[2])));
                } else {
                    System.out.println("Lectura inválida: [" + datos[0] + ", " + datos[1] + ", " + datos[2] + "]");
                }
            }

            // Ordeno por sensorId y timestamp ascendente
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Collections.sort(lecturasValidas, (Lectura l1, Lectura l2) -> {
                // Si tienen el mismo id, ordena según el timestamp
                if (Integer.parseInt(l1.getId()) == Integer.parseInt(l2.getId())) {
                    LocalDateTime aux1 = LocalDateTime.parse(l1.getTimestamp(), formatter);
                    LocalDateTime aux2 = LocalDateTime.parse(l2.getTimestamp(), formatter);
                    return aux1.compareTo(aux2);
                }
                return l1.getId().compareTo(l2.getId());
            });

            // Muestro por pantalla las lecturas válidas ordenadas
            System.out.println("----- LECTURAS VÁLIDAS -----");
            for (Lectura lec : lecturasValidas) {
                System.out.println(lec.mostrarLectura());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
