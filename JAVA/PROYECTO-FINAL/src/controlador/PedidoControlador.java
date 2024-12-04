/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

/**
 * Controlador encargado de manejar las operaciones relacionadas con los pedidos en el sistema.
 * Permite agregar, eliminar, actualizar, y buscar pedidos en una lista.
 * 
 * La lista de pedidos actúa como una base de datos simulada.
 * 
 * @author YARDY
 */
public class PedidoControlador {
    
    // Lista de pedidos (simula una base de datos)
    private List<Pedido> pedidos;

    /**
     * Constructor que inicializa la lista de pedidos.
     */
    public PedidoControlador() {
        this.pedidos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo pedido a la lista.
     * 
     * @param pedido Objeto {@link Pedido} que se desea agregar a la lista.
     * @return true si el pedido se agrega correctamente, false si no.
     */
    public boolean agregarPedido(Pedido pedido) {
        return pedidos.add(pedido);
    }

    /**
     * Elimina un pedido de la lista por su ID.
     * 
     * @param id ID del pedido que se desea eliminar.
     * @return true si el pedido se elimina correctamente, false si no se encontró el pedido.
     */
    public boolean eliminarPedido(int id) {
        Pedido pedido = buscarPedidoPorId(id); // Busca el pedido por ID
        if (pedido != null) {
            return pedidos.remove(pedido); // Elimina el pedido si existe
        }
        return false; // Retorna false si no se encontró el pedido
    }

    /**
     * Actualiza un pedido en la lista con los nuevos valores proporcionados.
     * 
     * @param pedidoActualizado Objeto {@link Pedido} con los nuevos valores.
     * @return true si el pedido se actualiza correctamente, false si el pedido no existe.
     */
    public boolean actualizarPedido(Pedido pedidoActualizado) {
        Pedido pedido = buscarPedidoPorId(pedidoActualizado.getId());
        if (pedido != null) {
            pedido.setId_sala(pedidoActualizado.getId_sala());
            pedido.setNum_mesa(pedidoActualizado.getNum_mesa());
            pedido.setFecha(pedidoActualizado.getFecha());
            pedido.setTotal(pedidoActualizado.getTotal());
            pedido.setSala(pedidoActualizado.getSala());
            pedido.setUsuario(pedidoActualizado.getUsuario());
            pedido.setEstado(pedidoActualizado.getEstado());
            return true; // Retorna true si la actualización fue exitosa
        }
        return false; // Retorna false si el pedido no fue encontrado
    }

    /**
     * Busca un pedido en la lista por su ID.
     * 
     * @param id ID del pedido que se busca.
     * @return El objeto {@link Pedido} encontrado, o null si no existe.
     */
    public Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido; // Retorna el pedido si se encuentra
            }
        }
        return null; // Retorna null si el pedido no se encuentra
    }

    /**
     * Obtiene la lista completa de pedidos.
     * 
     * @return Lista de objetos {@link Pedido}.
     */
    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }

    /**
     * Obtiene los pedidos filtrados por estado (e.g., "pendiente", "completado").
     * 
     * @param estado Estado de los pedidos a buscar.
     * @return Lista de pedidos con el estado especificado.
     */
    public List<Pedido> obtenerPedidosPorEstado(String estado) {
        List<Pedido> pedidosPorEstado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstado().equalsIgnoreCase(estado)) {
                pedidosPorEstado.add(pedido); // Agrega el pedido si coincide con el estado
            }
        }
        return pedidosPorEstado;
    }

    /**
     * Obtiene los pedidos filtrados por sala (e.g., "Sala 1", "Sala 2").
     * 
     * @param sala Nombre de la sala a filtrar.
     * @return Lista de pedidos asociados a la sala especificada.
     */
    public List<Pedido> obtenerPedidosPorSala(String sala) {
        List<Pedido> pedidosPorSala = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getSala().equalsIgnoreCase(sala)) {
                pedidosPorSala.add(pedido); // Agrega el pedido si coincide con la sala
            }
        }
        return pedidosPorSala;
    }

    /**
     * Obtiene los pedidos filtrados por fecha (e.g., "2024-12-01").
     * 
     * @param fecha Fecha de los pedidos a filtrar.
     * @return Lista de pedidos con la fecha especificada.
     */
    public List<Pedido> obtenerPedidosPorFecha(String fecha) {
        List<Pedido> pedidosPorFecha = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getFecha().equalsIgnoreCase(fecha)) {
                pedidosPorFecha.add(pedido); // Agrega el pedido si coincide con la fecha
            }
        }
        return pedidosPorFecha;
    }
}
