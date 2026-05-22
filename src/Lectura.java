
public class Lectura {

    private String id;
    private String timestamp;
    private double valor;

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Constructor con parámetros
     *
     * @param id Id de la lectura
     * @param timestamp Timestamp generado de la lectura
     * @param valor Valor medido por la lectura
     */
    public Lectura(String id, String timestamp, double valor) {
        this.id = id;
        this.timestamp = timestamp;
        this.valor = valor;
    }

    /**
     * Devuelve los datos de la lectura
     *
     * @return Una cadena de caracteres con los datos de la lectura
     */
    public String mostrarLectura() {
        return "[" + this.getId() + ", " + this.getTimestamp() + ", " + this.getValor() + "]";
    }
}
