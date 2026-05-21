
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Esta clase lanza los procesos que simulan la salida de datos de los sensores
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./src", "SimularLecturas");
            for (int i = 0; i < 50; i++) {
                String linea = "";
                Process proceso = pb.start();
                BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    System.out.println(":::::TRAZA SALIDA NORMAL:::::");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
