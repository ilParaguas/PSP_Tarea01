
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LimpiarYOrdenarLecturas {

    public static void main(String[] args) throws Exception {
        System.out.println("ENTRO");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linea = "";
            System.out.println("ESTOY DENTRO");
            while ((linea = br.readLine()) != null) {
                System.out.println("LINEA");
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("SALGO");
    }
}
