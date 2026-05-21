
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;

//Genera 50 lecturas de sensores por salida estándar, una por línea, en formato CSV
public class SimularLecturas {

    // Método que genera una linea aleatoria en formato csv
    String simular() {

        // Cabecera aleatoria <sensorId>;<timestamp>;<valor>
        // Id aleatorio
        int id = (int) (Math.random() * 50) + 1;

        // Timestamp aleatoria
        LocalDate date = LocalDate.now().minus(Period.ofDays(new Random().nextInt(2685)));
        LocalTime time = LocalTime.of(new Random().nextInt(0, 24),
                new Random().nextInt(0, 60),
                new Random().nextInt(0, 60));
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateTime.format(dtf);

        // Valor aleatorio
        int aux2 = (int) (Math.random() * 100) + 1;
        int aux1 = (int) (Math.random() * 100) + 1;
        String valor = aux1 + "." + aux2;

        return (id + ";" + timestamp + ";" + valor);
    }

    public void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(simular());
        }
        // Mostrar por pantalla con stdout?
    }
}
