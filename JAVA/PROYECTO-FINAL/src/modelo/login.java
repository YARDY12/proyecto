package modelo;

/**
 * Representa un usuario en el sistema, incluyendo información personal como
 * nombre, apellido, correo electrónico, número de celular, DNI, género,
 * dirección, contraseña y rol del usuario.
 *
 * <p>
 * Esta clase se utiliza para almacenar los datos relacionados con el login de
 * los usuarios en el sistema, así como para facilitar la autenticación y
 * autorización basadas en su rol.</p>
 *
 * @author YARDY
 */
public class login {

    /**
     * El ID único del usuario
     */
    private int id;

    /**
     * El nombre del usuario
     */
    private String nombre;

    /**
     * El apellido del usuario
     */
    private String apellido;

    /**
     * El correo electrónico del usuario
     */
    private String correo;

    /**
     * El número de celular del usuario
     */
    private int celular;

    /**
     * El DNI del usuario
     */
    private int dni;

    /**
     * El género del usuario
     */
    private String genero;

    /**
     * La dirección del usuario
     */
    private String direccion;

    /**
     * La contraseña del usuario
     */
    private String pass;

    /**
     * El rol del usuario (por ejemplo, "admin", "usuario")
     */
    private String rol;

    /**
     * Constructor vacío de la clase login. Inicializa un objeto login sin
     * valores predeterminados.
     */
    public login() {
    }

    /**
     * Constructor de la clase login con parámetros para inicializar sus
     * atributos.
     *
     * @param id El ID único del usuario.
     * @param nombre El nombre del usuario.
     * @param apellido El apellido del usuario.
     * @param correo El correo electrónico del usuario.
     * @param celular El número de celular del usuario.
     * @param dni El DNI del usuario.
     * @param genero El género del usuario.
     * @param direccion La dirección del usuario.
     * @param pass La contraseña del usuario.
     * @param rol El rol del usuario (por ejemplo, "admin", "usuario").
     */
    public login(int id, String nombre, String apellido, String correo, int celular, int dni, String genero, String direccion, String pass, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.dni = dni;
        this.genero = genero;
        this.direccion = direccion;
        this.pass = pass;
        this.rol = rol;
    }

    /**
     * Obtiene el ID único del usuario.
     *
     * @return El ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID único del usuario.
     *
     * @param id El nuevo ID del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return El apellido del usuario.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellido El nuevo apellido del usuario.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo El nuevo correo del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de celular del usuario.
     *
     * @return El celular del usuario.
     */
    public int getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular del usuario.
     *
     * @param celular El nuevo número de celular del usuario.
     */
    public void setCelular(int celular) {
        this.celular = celular;
    }

    /**
     * Obtiene el DNI del usuario.
     *
     * @return El DNI del usuario.
     */
    public int getDni() {
        return dni;
    }

    /**
     * Establece el DNI del usuario.
     *
     * @param dni El nuevo DNI del usuario.
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el género del usuario.
     *
     * @return El género del usuario.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario.
     *
     * @param genero El nuevo género del usuario.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la dirección del usuario.
     *
     * @return La dirección del usuario.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del usuario.
     *
     * @param direccion La nueva dirección del usuario.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param pass La nueva contraseña del usuario.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Obtiene el rol del usuario.
     *
     * @return El rol del usuario.
     */
    public String getRol() {
        return rol;
    }

    /**
     * Establece el rol del usuario.
     *
     * @param rol El nuevo rol del usuario.
     */
    public void setRol(String rol) {
        this.rol = rol;
    }
}
