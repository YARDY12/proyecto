/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.ClienteDAO;
import java.time.LocalDate;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author YARDY
 */
public class ClienteControlador {
    
    private ClienteDAO dao;

    public ClienteControlador(ClienteDAO dao) {
        this.dao = dao;
    }

    public void agregarCliente(String nombre, String apellido, int dni, LocalDate fecha_nac, String correo, int telefono, String direccion, String genero) {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDni(dni);
        cliente.setFecha_nac(fecha_nac);
        cliente.setCorreo(correo);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setGenero(genero);
        
    }

    public List<Cliente> cargarClientes() {
        
        return null;
    }

    public void actualizarCliente(int id_cliente, String nombre, String apellido, int dni, LocalDate fecha_nac, String correo, int telefono, String direccion, String genero) {
        Cliente cliente = new Cliente(id_cliente, nombre, apellido, dni, fecha_nac, correo, telefono, direccion, genero);
       
    }

    public void eliminarCliente(int id_cliente) {
      
    }

    public Cliente buscarClientePorId(int id_cliente) {
        return null;
    }
    
}
