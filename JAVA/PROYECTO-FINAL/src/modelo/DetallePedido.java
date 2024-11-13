/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author YARDY
 */
public class DetallePedido {
    
    private int id_detallepedido;
    private String nombre;
    private double precio;
    private int cantidad;
    private String comentario;
    private Pedido id_pedido;

    public DetallePedido() {
    }

    public DetallePedido(int id_detallepedido, String nombre, double precio, int cantidad, String comentario, Pedido id_pedido) {
        this.id_detallepedido = id_detallepedido;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.id_pedido = id_pedido;
    }

    public int getId_detallepedido() {
        return id_detallepedido;
    }

    public void setId_detallepedido(int id_detallepedido) {
        this.id_detallepedido = id_detallepedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Pedido getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedido id_pedido) {
        this.id_pedido = id_pedido;
    }

    
    
    
}
