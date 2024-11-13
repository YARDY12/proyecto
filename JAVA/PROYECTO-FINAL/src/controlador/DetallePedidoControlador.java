/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.DetallePedidoDAO;
import java.util.List;
import modelo.DetallePedido;
import modelo.Pedido;

/**
 *
 * @author YARDY
 */
public class DetallePedidoControlador {
    
    private DetallePedidoDAO dao;

    public DetallePedidoControlador(DetallePedidoDAO dao) {
        this.dao = dao;
    }

    public void agregarDetallePedido(String nombre, double precio, int cantidad, String comentario, Pedido id_pedido) {
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setNombre(nombre);
        detallePedido.setPrecio(precio);
        detallePedido.setCantidad(cantidad);
        detallePedido.setComentario(comentario);
        detallePedido.setId_pedido(id_pedido);
        
    }

    public List<DetallePedido> cargarDetallesPedido() {
        
        return null;
    }

    public void actualizarDetallePedido(int id_detallepedido, String nombre, double precio, int cantidad, String comentario, Pedido id_pedido) {
        DetallePedido detallePedido = new DetallePedido(id_detallepedido, nombre, precio, cantidad, comentario, id_pedido);
        
    }

    public void eliminarDetallePedido(int id_detallepedido) {
        
    }

    public DetallePedido buscarDetallePedidoPorId(int id_detallepedido) {
        
        return null;
        
    }
    
    
}
