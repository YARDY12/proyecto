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
 *
 * @author YARDY
 */
public class SalaDAO {
    
    // Variables para manejar la conexión y las consultas SQL
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexion cn = new Conexion();

    // Método para registrar una nueva sala
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

    // Método para listar todas las salas
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

    // Método para eliminar una sala por ID
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

    // Método para modificar una sala existente
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

    // Método para cerrar la conexión
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
