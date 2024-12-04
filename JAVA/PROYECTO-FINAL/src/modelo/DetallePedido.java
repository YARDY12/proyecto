/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa un detalle de un pedido dentro del sistema.
 * Contiene información sobre el nombre del plato, su precio, cantidad, comentario asociado,
 * el ID del pedido al que pertenece, el tipo de plato y el estado del detalle del pedido.
 * 
 * @author YARDY
 */
public class DetallePedido {

    /** El ID único del detalle del pedido */
    private int id_detallepedido;

    /** El nombre del plato o producto en el pedido */
    private String nombre;

    /** El precio del plato o producto */
    private double precio;

    /** La cantidad del plato o producto solicitado */
    private int cantidad;

    /** Comentarios adicionales sobre el pedido (por ejemplo, preferencias del cliente) */
    private String comentario;

    /** El ID del pedido al que pertenece este detalle */
    private int id_pedido;

    /** El tipo de plato (por ejemplo, "Entrada", "Plato principal", "Postre") */
    private String tipoPlato;

    /** El estado del detalle del pedido (por ejemplo, "En preparación", "Entregado", "Cancelado") */
    private String estado;

    /**
     * Constructor vacío de la clase DetallePedido.
     * Inicializa un objeto DetallePedido sin valores predeterminados.
     */
    public DetallePedido() {
    }

    /**
     * Constructor de la clase DetallePedido con parámetros básicos.
     * Inicializa un objeto DetallePedido con los valores proporcionados.
     * 
     * @param id_detallepedido El ID único del detalle del pedido.
     * @param nombre El nombre del plato o producto.
     * @param precio El precio del plato o producto.
     * @param cantidad La cantidad solicitada del plato o producto.
     * @param comentario Un comentario adicional relacionado con el pedido.
     * @param id_pedido El ID del pedido al que pertenece este detalle.
     */
    public DetallePedido(int id_detallepedido, String nombre, double precio, int cantidad, String comentario, int id_pedido) {
        this.id_detallepedido = id_detallepedido;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.id_pedido = id_pedido;
    }

    /**
     * Constructor de la clase DetallePedido con parámetros adicionales para tipo de plato.
     * Inicializa un objeto DetallePedido con los valores proporcionados.
     * 
     * @param id_detallepedido El ID único del detalle del pedido.
     * @param nombre El nombre del plato o producto.
     * @param precio El precio del plato o producto.
     * @param cantidad La cantidad solicitada del plato o producto.
     * @param comentario Un comentario adicional relacionado con el pedido.
     * @param id_pedido El ID del pedido al que pertenece este detalle.
     * @param tipoPlato El tipo de plato (por ejemplo, "Entrada", "Plato principal", "Postre").
     */
    public DetallePedido(int id_detallepedido, String nombre, double precio, int cantidad, String comentario, int id_pedido, String tipoPlato) {
        this.id_detallepedido = id_detallepedido;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.id_pedido = id_pedido;
        this.tipoPlato = tipoPlato;
    }

    /**
     * Constructor de la clase DetallePedido con parámetros completos.
     * Inicializa un objeto DetallePedido con los valores proporcionados.
     * 
     * @param id_detallepedido El ID único del detalle del pedido.
     * @param nombre El nombre del plato o producto.
     * @param precio El precio del plato o producto.
     * @param cantidad La cantidad solicitada del plato o producto.
     * @param comentario Un comentario adicional relacionado con el pedido.
     * @param id_pedido El ID del pedido al que pertenece este detalle.
     * @param tipoPlato El tipo de plato (por ejemplo, "Entrada", "Plato principal", "Postre").
     * @param estado El estado del detalle del pedido (por ejemplo, "En preparación", "Entregado").
     */
    public DetallePedido(int id_detallepedido, String nombre, double precio, int cantidad, String comentario, int id_pedido, String tipoPlato, String estado) {
        this.id_detallepedido = id_detallepedido;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.id_pedido = id_pedido;
        this.tipoPlato = tipoPlato;
        this.estado = estado;
    }

    /**
     * Obtiene el ID único del detalle del pedido.
     * 
     * @return El ID del detalle del pedido.
     */
    public int getId_detallepedido() {
        return id_detallepedido;
    }

    /**
     * Establece el ID único del detalle del pedido.
     * 
     * @param id_detallepedido El nuevo ID del detalle del pedido.
     */
    public void setId_detallepedido(int id_detallepedido) {
        this.id_detallepedido = id_detallepedido;
    }

    /**
     * Obtiene el nombre del plato o producto.
     * 
     * @return El nombre del plato o producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del plato o producto.
     * 
     * @param nombre El nuevo nombre del plato o producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del plato o producto.
     * 
     * @return El precio del plato o producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del plato o producto.
     * 
     * @param precio El nuevo precio del plato o producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad solicitada del plato o producto.
     * 
     * @return La cantidad solicitada.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad solicitada del plato o producto.
     * 
     * @param cantidad La nueva cantidad solicitada.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el comentario adicional relacionado con el pedido.
     * 
     * @return El comentario del pedido.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Establece el comentario adicional relacionado con el pedido.
     * 
     * @param comentario El nuevo comentario del pedido.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtiene el ID del pedido al que pertenece este detalle.
     * 
     * @return El ID del pedido.
     */
    public int getId_pedido() {
        return id_pedido;
    }

    /**
     * Establece el ID del pedido al que pertenece este detalle.
     * 
     * @param id_pedido El nuevo ID del pedido.
     */
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    /**
     * Obtiene el tipo de plato (por ejemplo, "Entrada", "Plato principal").
     * 
     * @return El tipo de plato.
     */
    public String getTipoPlato() {
        return tipoPlato;
    }

    /**
     * Establece el tipo de plato.
     * 
     * @param tipoPlato El nuevo tipo de plato.
     */
    public void setTipoPlato(String tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    /**
     * Obtiene el estado del detalle del pedido.
     * 
     * @return El estado del pedido (por ejemplo, "En preparación", "Entregado").
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del detalle del pedido.
     * 
     * @param estado El nuevo estado del pedido.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
