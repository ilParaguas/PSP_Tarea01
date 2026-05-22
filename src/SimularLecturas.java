
import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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

        // Valor aleatorio dentro de los valores adminitidos
        Random rand = new Random();
        Double aux = rand.nextDouble(59 - -20 + 1) + -20;

        // Normalizo valor a 2 decimales
        DecimalFormat df = new DecimalFormat("#.##");
        Double valor = Double.valueOf(df.format(aux).replace(",", "."));

        return (id + ";" + timestamp + ";" + valor);
    }

    public void main(String[] args) {
        // Genera 50 lecturas aleatorias y las envía por STDOUT
        for (int i = 0; i < 50; i++) {
            System.out.println(simular());
        }
    }
}
