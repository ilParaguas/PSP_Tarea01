
import java.io.*;
import java.nio.charset.StandardCharsets;

public class TransformarLecturas {

    public static void main(String[] args) {
        // Check args
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(args[0]),
                // Especificación necesaria para hacer correctamente los cambios de tipo de dato double
                StandardCharsets.UTF_16
        )); BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]))) {
            double minAlert = Double.parseDouble(args[2].substring("--minAlert=".length()));
            String linea;
            String result;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (Double.compare(Double.parseDouble(partes[2]), minAlert) >= 0) {
                    result = "ALERTA";
                } else {
                    result = "OK";
                }
                // Escribir salida csv
                bw.write(partes[0] + ";" + partes[1] + ";" + partes[2] + ";" + result);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
