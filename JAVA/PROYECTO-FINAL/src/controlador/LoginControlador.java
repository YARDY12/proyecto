/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.login;

/**
 * Controlador encargado de manejar las operaciones relacionadas con el login de los usuarios.
 * Permite agregar, eliminar, actualizar, y verificar el inicio de sesión de los usuarios en el sistema.
 * 
 * La lista de usuarios actúa como una base de datos simulada.
 * 
 * @author YARDY
 */
public class LoginControlador {
    
    // Lista de usuarios (simula una base de datos)
    private List<login> usuarios;

    /**
     * Constructor que inicializa la lista de usuarios.
     */
    public LoginControlador() {
        this.usuarios = new ArrayList<>();
    }

    /**
     * Agrega un nuevo usuario a la lista.
     * 
     * @param usuario Objeto {@link login} que se desea agregar a la lista.
     * @return true si el usuario se agrega correctamente, false si el correo ya está registrado.
     */
    public boolean agregarUsuario(login usuario) {
        // Verifica si el correo ya está registrado
        for (login u : usuarios) {
            if (u.getCorreo().equals(usuario.getCorreo())) {
                return false; // El usuario ya existe
            }
        }
        return usuarios.add(usuario); // Agrega el usuario si el correo no está registrado
    }

    /**
     * Elimina un usuario de la lista por su ID.
     * 
     * @param id ID del usuario que se desea eliminar.
     * @return true si el usuario se elimina correctamente, false si no se encontró el usuario.
     */
    public boolean eliminarUsuario(int id) {
        login usuario = buscarUsuarioPorId(id); // Busca el usuario por ID
        if (usuario != null) {
            return usuarios.remove(usuario); // Elimina el usuario si existe
        }
        return false; // Retorna false si el usuario no se encuentra
    }

    /**
     * Actualiza un usuario en la lista con los nuevos valores proporcionados.
     * 
     * @param usuarioActualizado Objeto {@link login} con los nuevos valores.
     * @return true si el usuario se actualiza correctamente, false si el usuario no existe.
     */
    public boolean actualizarUsuario(login usuarioActualizado) {
        login usuario = buscarUsuarioPorId(usuarioActualizado.getId());
        if (usuario != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setCelular(usuarioActualizado.getCelular());
            usuario.setDni(usuarioActualizado.getDni());
            usuario.setGenero(usuarioActualizado.getGenero());
            usuario.setDireccion(usuarioActualizado.getDireccion());
            usuario.setPass(usuarioActualizado.getPass());
            usuario.setRol(usuarioActualizado.getRol());
            return true; // Retorna true si la actualización fue exitosa
        }
        return false; // Retorna false si el usuario no fue encontrado
    }

    /**
     * Busca un usuario en la lista por su ID.
     * 
     * @param id ID del usuario que se busca.
     * @return El objeto {@link login} encontrado, o null si no existe.
     */
    public login buscarUsuarioPorId(int id) {
        for (login usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario; // Retorna el usuario si se encuentra
            }
        }
        return null; // Retorna null si el usuario no se encuentra
    }

    /**
     * Obtiene la lista completa de usuarios.
     * 
     * @return Lista de objetos {@link login}.
     */
    public List<login> obtenerUsuarios() {
        return usuarios;
    }

    /**
     * Verifica las credenciales de inicio de sesión de un usuario.
     * 
     * @param correo Correo del usuario.
     * @param pass Contraseña del usuario.
     * @return true si las credenciales son correctas, false si no lo son.
     */
    public boolean verificarLogin(String correo, String pass) {
        for (login usuario : usuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getPass().equals(pass)) {
                return true; // Login exitoso
            }
        }
        return false; // Credenciales incorrectas
    }

    /**
     * Obtiene los usuarios filtrados por rol (ejemplo: "admin", "empleado").
     * 
     * @param rol Rol de los usuarios a buscar.
     * @return Lista de usuarios con el rol especificado.
     */
    public List<login> obtenerUsuariosPorRol(String rol) {
        List<login> usuariosPorRol = new ArrayList<>();
        for (login usuario : usuarios) {
            if (usuario.getRol().equalsIgnoreCase(rol)) {
                usuariosPorRol.add(usuario); // Agrega el usuario si coincide con el rol
            }
        }
        return usuariosPorRol;
    }
}
