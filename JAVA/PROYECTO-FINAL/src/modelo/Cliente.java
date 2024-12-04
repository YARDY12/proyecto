/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
/**
 * Clase que representa a un cliente del establecimiento.
 * Un cliente tiene atributos como su nombre, apellido, documento de identidad, 
 * fecha de nacimiento, correo electrónico, teléfono, dirección y género.
 * 
 * <p>El cliente realiza pedidos en el establecimiento y puede tener información personal
 * relacionada con su identidad y contacto. Además, su información puede ser utilizada 
 * para realizar reservas o gestionar pedidos futuros.</p>
 * 
 * @author YARDY
 */
public class Cliente {

    private int id_cliente;
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fecha_nac;
    private String correo;
    private int telefono;
    private String direccion;
    private String genero;

    /**
     * Constructor vacío que crea un objeto {@link Cliente} sin inicializar los valores.
     * Este constructor permite crear un cliente sin proporcionar sus datos de inmediato, 
     * lo que permite su inicialización posterior.
     */
    public Cliente() {
    }

    /**
     * Constructor que crea un objeto {@link Cliente} con los valores proporcionados.
     * Este constructor inicializa un cliente con la información personal y de contacto 
     * necesaria para gestionar sus interacciones en el establecimiento.
     * 
     * @param id_cliente El ID único del cliente, utilizado para su identificación dentro del sistema.
     * @param nombre El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param dni El número de DNI del cliente, utilizado como documento de identidad.
     * @param fecha_nac La fecha de nacimiento del cliente.
     * @param correo El correo electrónico del cliente, utilizado para contacto y notificaciones.
     * @param telefono El número de teléfono del cliente.
     * @param direccion La dirección de residencia del cliente.
     * @param genero El género del cliente.
     */
    public Cliente(int id_cliente, String nombre, String apellido, int dni, LocalDate fecha_nac, String correo, int telefono, String direccion, String genero) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_nac = fecha_nac;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
    }

    // Getters and Setters

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
