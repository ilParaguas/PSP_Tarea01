
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    // Esta clase lanza los procesos que simulan la salida de datos de los sensores
    public static void main(String[] args) {
        Process p;
        String ruta = System.getProperty("user.dir") + "/bin";
        try {
            String linea;
            for (int i = 0; i < 50; i++) {
                p = new ProcessBuilder("java", "-cp", ruta, "SimularLecturas").inheritIO().start();
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    System.out.println("aaaaaaaaaaaaaaaaaaa");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
