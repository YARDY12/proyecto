/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Sala;
import conf.Conexion;
import java.util.List;

/**
 * Clase DAO para manejar las operaciones de base de datos relacionadas con la entidad Sala.
 * Esta clase proporciona métodos para registrar, listar, eliminar y modificar salas en la base de datos.
 * 
 * @author YARDY
 */
public class SalaDAO {

    private Connection con;  // Conexión a la base de datos
    private PreparedStatement ps;  // Sentencia SQL preparada
    private ResultSet rs;  // Resultados de la consulta
    private final Conexion cn = new Conexion();  // Objeto para la conexión a la base de datos

    /**
     * Registra una nueva sala en la base de datos.
     * 
     * @param sala El objeto Sala que contiene los datos a insertar.
     * @return true si la sala fue registrada correctamente, false en caso contrario.
     */
    public boolean registrarSala(Sala sala) {
        String sql = "INSERT INTO sala(nombre, mesa) VALUES (?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sala.getNombre());
            ps.setInt(2, sala.getMesa());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar sala: " + e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    /**
     * Obtiene todas las salas registradas en la base de datos.
     * 
     * @return Una lista de objetos Sala con los datos de las salas.
     */
    public List<Sala> listarSalas() {
        List<Sala> lista = new ArrayList<>();
        String sql = "SELECT * FROM sala";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sala sala = new Sala();
                sala.setId_sala(rs.getInt("id_sala"));
                sala.setNombre(rs.getString("nombre"));
                sala.setMesa(rs.getInt("mesa"));
                lista.add(sala);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar salas: " + e.toString());
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    /**
     * Elimina una sala de la base de datos por su ID.
     * 
     * @param id_sala El ID de la sala a eliminar.
     * @return true si la sala fue eliminada correctamente, false en caso contrario.
     */
    public boolean eliminarSala(int id_sala) {
        String sql = "DELETE FROM sala WHERE id_sala = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_sala);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar sala: " + e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    /**
     * Modifica los datos de una sala existente en la base de datos.
     * 
     * @param sala El objeto Sala con los datos actualizados.
     * @return true si la sala fue modificada correctamente, false en caso contrario.
     */
    public boolean modificarSala(Sala sala) {
        String sql = "UPDATE sala SET nombre = ?, mesa = ? WHERE id_sala = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sala.getNombre());
            ps.setInt(2, sala.getMesa());
            ps.setInt(3, sala.getId_sala());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al modificar sala: " + e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    /**
     * Cierra la conexión con la base de datos.
     * Este método se asegura de liberar los recursos relacionados con la conexión.
     */
    private void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.toString());
        }
    }
}
