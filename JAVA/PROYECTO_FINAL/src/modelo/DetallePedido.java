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
    private Pedido id_pedido;
    private Producto id_producto;
    private double total;
    private int cantidad;
    private String estado;

    public DetallePedido() {
    }

    public DetallePedido(int id_detallepedido, Pedido id_pedido, Producto id_producto, double total, int cantidad, String estado) {
        this.id_detallepedido = id_detallepedido;
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
        this.total = total;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public int getId_detallepedido() {
        return id_detallepedido;
    }

    public void setId_detallepedido(int id_detallepedido) {
        this.id_detallepedido = id_detallepedido;
    }

    public Pedido getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Pedido id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
