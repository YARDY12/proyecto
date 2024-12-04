package modelo;

/**
 * Representa un producto en el sistema.
 * Esta clase contiene detalles de un producto como su ID, nombre, tipo de plato, precio y descripción.
 * 
 * @author YARDY
 */
public class Producto {

    /** El ID único del producto */
    private int id_producto;

    /** El nombre del producto */ 
    private String nom_producto;

    /** El tipo de plato del producto (por ejemplo, "Entrada", "Plato principal", "Postre") */
    private String tipoPlato;

    /** El precio del producto */
    private double precio;

    /** Una descripción del producto */
    private String descripcion;

    /**
     * Constructor vacío de la clase Producto.
     * Inicializa un objeto Producto sin valores predeterminados.
     */
    public Producto() {
    }

    /**
     * Constructor de la clase Producto con parámetros.
     * Inicializa un objeto Producto con los valores proporcionados.
     * 
     * @param id_producto El ID único del producto.
     * @param nom_producto El nombre del producto.
     * @param tipoPlato El tipo de plato del producto.
     * @param precio El precio del producto.
     * @param descripcion Una descripción del producto.
     */
    public Producto(int id_producto, String nom_producto, String tipoPlato, double precio, String descripcion) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.tipoPlato = tipoPlato;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del producto.
     * 
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     * 
     * @param descripcion La nueva descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el ID del producto.
     * 
     * @return El ID del producto.
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * Establece el ID del producto.
     * 
     * @param id_producto El nuevo ID del producto.
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getNom_producto() {
        return nom_producto;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param nom_producto El nuevo nombre del producto.
     */
    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    /**
     * Obtiene el tipo de plato del producto.
     * 
     * @return El tipo de plato del producto.
     */
    public String getTipoPlato() {
        return tipoPlato;
    }

    /**
     * Establece el tipo de plato del producto.
     * 
     * @param tipoPlato El nuevo tipo de plato del producto.
     */
    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    /**
     * Obtiene el precio del producto.
     * 
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * 
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}