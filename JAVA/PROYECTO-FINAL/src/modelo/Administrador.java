/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que representa un Administrador, un tipo específico de {@link Persona}.
 * Extiende las propiedades y comportamientos de la clase {@link Persona} para
 * representar a un usuario con privilegios administrativos dentro del sistema.
 *
 * <p>
 * El administrador tiene acceso a funcionalidades especiales, como gestionar
 * empleados, visualizar reportes y realizar configuraciones en el sistema.</p>
 *
 * @author YARDY
 */
public class Administrador extends Persona {

    /**
     * Constructor vacío que crea un objeto {@link Administrador} sin
     * inicializar los valores.
     */
    public Administrador() {
    }

    /**
     * Constructor que crea un objeto {@link Administrador} con los valores
     * proporcionados. Este constructor inicializa un {@link Administrador} con
     * la información de un empleado y su rol como administrador.
     *
     * @param id_empleado El ID único del empleado.
     * @param nombre El nombre del administrador.
     * @param apellido El apellido del administrador.
     * @param correo El correo electrónico del administrador.
     * @param celular El número de celular del administrador.
     * @param dni El DNI del administrador.
     * @param genero El género del administrador.
     * @param direccion La dirección del administrador.
     * @param pass La contraseña del administrador.
     * @param rol El rol del administrador (debería ser "Administrador").
     */
    public Administrador(int id_empleado, String nombre, String apellido, String correo, int celular, int dni, String genero, String direccion, String pass, String rol) {
        super(id_empleado, nombre, apellido, correo, celular, dni, genero, direccion, pass, rol);
    }
}
