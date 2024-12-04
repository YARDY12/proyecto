package conf;

/**
 * Clase para representar la configuración de un negocio o entidad.
 *
 * Esta clase almacena detalles básicos como el ID, RUC, nombre, teléfono,
 * dirección y un mensaje relacionado con el negocio o entidad que está siendo
 * configurado.
 *
 * @author YARDY
 */
public class Config {

    private int id;  // ID único para la configuración
    private String ruc;  // RUC (Registro Único de Contribuyentes) del negocio
    private String nombre;  // Nombre del negocio
    private String telefono;  // Teléfono del negocio
    private String direccion;  // Dirección del negocio
    private String mensaje;  // Mensaje relacionado con el negocio

    /**
     * Constructor vacío para la clase Config.
     *
     * Este constructor no inicializa ningún atributo, y se usa principalmente
     * para instanciar el objeto sin parámetros y luego establecer sus valores
     * mediante setters.
     */
    public Config() {

    }

    /**
     * Constructor con parámetros para inicializar la configuración con valores
     * específicos.
     *
     * @param id El ID único de la configuración
     * @param ruc El RUC del negocio
     * @param nombre El nombre del negocio
     * @param telefono El teléfono del negocio
     * @param direccion La dirección del negocio
     * @param mensaje Un mensaje relacionado con el negocio
     */
    public Config(int id, String ruc, String nombre, String telefono, String direccion, String mensaje) {
        this.id = id;
        this.ruc = ruc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mensaje = mensaje;
    }

    // Métodos getter y setter para acceder y modificar los atributos de la clase
    /**
     * Obtiene el ID de la configuración.
     *
     * @return El ID de la configuración
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la configuración.
     *
     * @param id El nuevo ID para la configuración
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el RUC del negocio.
     *
     * @return El RUC del negocio
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * Establece el RUC del negocio.
     *
     * @param ruc El nuevo RUC para el negocio
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * Obtiene el nombre del negocio.
     *
     * @return El nombre del negocio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del negocio.
     *
     * @param nombre El nuevo nombre del negocio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el teléfono del negocio.
     *
     * @return El teléfono del negocio
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del negocio.
     *
     * @param telefono El nuevo teléfono del negocio
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del negocio.
     *
     * @return La dirección del negocio
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del negocio.
     *
     * @param direccion La nueva dirección del negocio
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el mensaje relacionado con el negocio.
     *
     * @return El mensaje del negocio
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece un mensaje relacionado con el negocio.
     *
     * @param mensaje El nuevo mensaje para el negocio
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
