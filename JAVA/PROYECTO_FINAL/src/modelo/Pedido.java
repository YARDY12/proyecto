/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author YARDY
 */
public class Pedido {
    
    private int id_pedido;
    private Cliente id_cliente;
    private Mesa id_mesa;
    private Persona id_empleado;
    private String descripcion;
    private double precio_unitario;
    private LocalDate fecha;

    public Pedido() {
    }

    public Pedido(int id_pedido, Cliente id_cliente, Mesa id_mesa, Persona id_empleado, String descripcion, double precio_unitario, LocalDate fecha) {
        this.id_pedido = id_pedido;
        this.id_cliente = id_cliente;
        this.id_mesa = id_mesa;
        this.id_empleado = id_empleado;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        this.fecha = fecha;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Mesa getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Mesa id_mesa) {
        this.id_mesa = id_mesa;
    }

    public Persona getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Persona id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    
}
