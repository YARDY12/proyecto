/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que representa a un Mesero, un tipo específico de {@link Persona}.
 * Extiende las propiedades y comportamientos de la clase {@link Persona} para
 * representar a un empleado encargado de atender a los clientes dentro del
 * sistema de la cevichería.
 *
 * <p>
 * El mesero tiene la responsabilidad de tomar pedidos, servir la comida y
 * gestionar las mesas dentro del establecimiento.</p>
 *
 * @author YARDY
 */
public class Mesero extends Persona {

    /**
     * Constructor vacío que crea un objeto {@link Mesero} sin inicializar los
     * valores.
     */
    public Mesero() {
    }

    /**
     * Constructor que crea un objeto {@link Mesero} con los valores
     * proporcionados. Este constructor inicializa un {@link Mesero} con la
     * información de un empleado y su rol como mesero.
     *
     * @param id_empleado El ID único del empleado.
     * @param nombre El nombre del mesero.
     * @param apellido El apellido del mesero.
     * @param correo El correo electrónico del mesero.
     * @param celular El número de celular del mesero.
     * @param dni El DNI del mesero.
     * @param genero El género del mesero.
     * @param direccion La dirección del mesero.
     * @param pass La contraseña del mesero.
     * @param rol El rol del mesero (debería ser "Mesero").
     */
    public Mesero(int id_empleado, String nombre, String apellido, String correo, int celular, int dni, String genero, String direccion, String pass, String rol) {
        super(id_empleado, nombre, apellido, correo, celular, dni, genero, direccion, pass, rol);
    }
}
