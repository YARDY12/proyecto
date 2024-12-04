/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 * Representa un pedido en el sistema. Un pedido contiene detalles como el ID,
 * sala, número de mesa, fecha, total, usuario y estado.
 *
 * @author YARDY
 */
public class Pedido {

    /**
     * El ID único del pedido
     */
    private int id;

    /**
     * El ID de la sala en la que se realizó el pedido
     */
    private int id_sala;

    /**
     * El número de la mesa donde se realizó el pedido
     */
    private int num_mesa;

    /**
     * La fecha en que se realizó el pedido
     */
    private String fecha;

    /**
     * El total de la factura del pedido
     */
    private double total;

    /**
     * El nombre de la sala donde se encuentra el pedido
     */
    private String sala;

    /**
     * El usuario que gestionó el pedido
     */
    private String usuario;

    /**
     * El estado actual del pedido (por ejemplo, "En preparación", "Entregado",
     * "Cancelado")
     */
    private String estado;

    /**
     * Constructor vacío de la clase Pedido. Inicializa un objeto Pedido sin
     * valores predeterminados.
     */
    public Pedido() {
    }

    /**
     * Constructor de la clase Pedido con parámetros. Inicializa un objeto
     * Pedido con los valores proporcionados.
     *
     * @param id El ID único del pedido.
     * @param id_sala El ID de la sala donde se realizó el pedido.
     * @param num_mesa El número de mesa donde se realizó el pedido.
     * @param fecha La fecha en que se realizó el pedido.
     * @param total El total de la factura del pedido.
     * @param sala El nombre de la sala donde se encuentra el pedido.
     * @param usuario El nombre del usuario que gestionó el pedido.
     * @param estado El estado actual del pedido.
     */
    public Pedido(int id, int id_sala, int num_mesa, String fecha, double total, String sala, String usuario, String estado) {
        this.id = id;
        this.id_sala = id_sala;
        this.num_mesa = num_mesa;
        this.fecha = fecha;
        this.total = total;
        this.sala = sala;
        this.usuario = usuario;
        this.estado = estado;
    }

    /**
     * Obtiene el ID del pedido.
     *
     * @return El ID del pedido.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del pedido.
     *
     * @param id El nuevo ID del pedido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el ID de la sala donde se realizó el pedido.
     *
     * @return El ID de la sala.
     */
    public int getId_sala() {
        return id_sala;
    }

    /**
     * Establece el ID de la sala donde se realizó el pedido.
     *
     * @param id_sala El nuevo ID de la sala.
     */
    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    /**
     * Obtiene el número de mesa donde se realizó el pedido.
     *
     * @return El número de mesa.
     */
    public int getNum_mesa() {
        return num_mesa;
    }

    /**
     * Establece el número de mesa donde se realizó el pedido.
     *
     * @param num_mesa El nuevo número de mesa.
     */
    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    /**
     * Obtiene la fecha en que se realizó el pedido.
     *
     * @return La fecha del pedido.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó el pedido.
     *
     * @param fecha La nueva fecha del pedido.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el total de la factura del pedido.
     *
     * @return El total del pedido.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de la factura del pedido.
     *
     * @param total El nuevo total del pedido.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Obtiene el nombre de la sala donde se encuentra el pedido.
     *
     * @return El nombre de la sala.
     */
    public String getSala() {
        return sala;
    }

    /**
     * Establece el nombre de la sala donde se encuentra el pedido.
     *
     * @param sala El nuevo nombre de la sala.
     */
    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     * Obtiene el nombre del usuario que gestionó el pedido.
     *
     * @return El nombre del usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre del usuario que gestionó el pedido.
     *
     * @param usuario El nuevo nombre del usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el estado del pedido.
     *
     * @return El estado del pedido.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del pedido.
     *
     * @param estado El nuevo estado del pedido.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
