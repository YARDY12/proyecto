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
import modelo.Producto;
import conf.Conexion;
import java.util.List;

/**
 * Clase que gestiona las operaciones CRUD para la entidad Producto en la base de datos.
 * Esta clase permite registrar, listar, modificar y eliminar productos de la base de datos.
 * 
 * <p>Las operaciones CRUD se realizan utilizando la conexión a la base de datos proporcionada
 * por la clase {@link Conexion} y son ejecutadas mediante sentencias SQL.</p>
 * 
 * @author YARDY
 */
public class ProductoDAO {
    
    private Connection con;
    private final Conexion cn = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * Registra un nuevo producto en la base de datos.
     * 
     * <p>Este método realiza una operación INSERT en la tabla {@code producto} para añadir un nuevo producto.</p>
     * 
     * @param producto El objeto {@link Producto} que contiene los datos a insertar.
     * @return {@code true} si la operación fue exitosa, {@code false} si ocurrió un error.
     */
    public boolean registrar(Producto producto) {
        String sql = "INSERT INTO producto (nom_producto, tipoPlato, descripcion, precio) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNom_producto());
            ps.setString(2, producto.getTipoPlato());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    /**
     * Obtiene una lista de productos de la base de datos que coinciden con el parámetro de búsqueda.
     * 
     * <p>Este método realiza una operación SELECT en la tabla {@code producto} y devuelve una lista de objetos {@link Producto}
     * que cumplen con el criterio de búsqueda.</p>
     * 
     * @param valor El valor de búsqueda que se utiliza en el nombre del producto.
     * @return Una lista de objetos {@link Producto} que coinciden con el parámetro de búsqueda.
     */
    public List<Producto> listar(String valor) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nom_producto LIKE ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + valor + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNom_producto(rs.getString("nom_producto"));
                producto.setTipoPlato(rs.getString("tipoPlato"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    /**
     * Elimina un producto de la base de datos por su ID.
     * 
     * <p>Este método realiza una operación DELETE en la tabla {@code producto} para eliminar el producto
     * cuyo ID coincida con el parámetro proporcionado.</p>
     * 
     * @param id_producto El ID del producto a eliminar.
     * @return {@code true} si la operación fue exitosa, {@code false} si ocurrió un error.
     */
    public boolean eliminar(int id_producto) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_producto);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    /**
     * Modifica los datos de un producto existente en la base de datos.
     * 
     * <p>Este método realiza una operación UPDATE en la tabla {@code producto} para actualizar los datos
     * del producto cuyo ID coincida con el parámetro proporcionado.</p>
     * 
     * @param producto El objeto {@link Producto} que contiene los datos a actualizar.
     * @return {@code true} si la operación fue exitosa, {@code false} si ocurrió un error.
     */
    public boolean modificar(Producto producto) {
        String sql = "UPDATE producto SET nom_producto=?, tipoPlato=?, descripcion=?, precio=? WHERE id_producto=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNom_producto());
            ps.setString(2, producto.getTipoPlato());
            ps.setString(3, producto.getDescripcion());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getId_producto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            cerrarConexion();
        }
    }

    /**
     * Cierra la conexión con la base de datos si está abierta.
     * 
     * <p>Este método se llama en el bloque {@code finally} para asegurarse de que la conexión se cierre
     * de manera adecuada al final de cada operación CRUD.</p>
     */
    private void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}

