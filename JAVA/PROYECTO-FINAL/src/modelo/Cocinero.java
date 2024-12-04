/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que representa a un Cocinero, un tipo específico de {@link Persona}.
 * Esta clase extiende las propiedades y comportamientos de la clase {@link Persona} 
 * para representar a un empleado encargado de la preparación de los platos en la cocina 
 * de un establecimiento.
 * 
 * <p>El cocinero tiene la responsabilidad de preparar los platos de acuerdo con los pedidos 
 * realizados por los clientes, asegurando la calidad de los mismos y cumpliendo con los tiempos 
 * establecidos por el restaurante o el establecimiento.</p>
 * 
 * <p>Un cocinero hereda atributos como el nombre, apellido, correo, número de celular, entre otros, 
 * de la clase {@link Persona}, y puede ser identificado por su ID único.</p>
 * 
 * @author YARDY
 */
public class Cocinero extends Persona {

    /**
     * Constructor vacío que crea un objeto {@link Cocinero} sin inicializar los valores.
     * Este constructor es útil para crear un cocinero sin asignar sus propiedades 
     * inmediatamente, lo que permite su inicialización posterior.
     */
    public Cocinero() {
    }

    /**
     * Constructor que crea un objeto {@link Cocinero} con los valores proporcionados.
     * Este constructor inicializa un {@link Cocinero} con la información de un empleado 
     * y su rol como cocinero, permitiendo asignar sus atributos básicos de forma directa.
     * 
     * @param id_empleado El ID único del empleado, utilizado para identificar al cocinero.
     * @param nombre El nombre del cocinero.
     * @param apellido El apellido del cocinero.
     * @param correo El correo electrónico del cocinero.
     * @param celular El número de celular del cocinero.
     * @param dni El DNI (Documento Nacional de Identidad) del cocinero.
     * @param genero El género del cocinero.
     * @param direccion La dirección del cocinero.
     * @param pass La contraseña asociada al perfil del cocinero.
     * @param rol El rol del cocinero, que debería ser "Cocinero".
     */
    public Cocinero(int id_empleado, String nombre, String apellido, String correo, int celular, int dni, String genero, String direccion, String pass, String rol) {
        super(id_empleado, nombre, apellido, correo, celular, dni, genero, direccion, pass, rol);
    }
}

