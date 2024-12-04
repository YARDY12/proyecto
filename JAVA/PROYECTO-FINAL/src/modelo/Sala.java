/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa una sala dentro del sistema, que contiene información sobre su
 * identificador, nombre y número de mesas disponibles.
 *
 * @author YARDY
 */
public class Sala {

    /**
     * El ID único de la sala
     */
    private int id_sala;

    /**
     * El nombre de la sala
     */
    private String nombre;

    /**
     * El número de mesas disponibles en la sala
     */
    private int mesa;

    /**
     * Constructor vacío de la clase Sala. Inicializa un objeto Sala sin valores
     * predeterminados.
     */
    public Sala() {
    }

    /**
     * Constructor de la clase Sala con parámetros para inicializar sus
     * atributos.
     *
     * @param id_sala El ID único de la sala.
     * @param nombre El nombre de la sala.
     * @param mesa El número de mesas disponibles en la sala.
     */
    public Sala(int id_sala, String nombre, int mesa) {
        this.id_sala = id_sala;
        this.nombre = nombre;
        this.mesa = mesa;
    }

    /**
     * Obtiene el ID único de la sala.
     *
     * @return El ID de la sala.
     */
    public int getId_sala() {
        return id_sala;
    }

    /**
     * Establece el ID único de la sala.
     *
     * @param id_sala El nuevo ID de la sala.
     */
    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    /**
     * Obtiene el nombre de la sala.
     *
     * @return El nombre de la sala.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la sala.
     *
     * @param nombre El nuevo nombre de la sala.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de mesas disponibles en la sala.
     *
     * @return El número de mesas en la sala.
     */
    public int getMesa() {
        return mesa;
    }

    /**
     * Establece el número de mesas disponibles en la sala.
     *
     * @param mesa El nuevo número de mesas en la sala.
     */
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
}
