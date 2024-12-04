package dao;

import conf.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.login;

/**
 * Clase encargada de gestionar las operaciones relacionadas con los usuarios
 * en la base de datos. Permite autenticar, registrar, editar, eliminar y listar
 * usuarios.
 */
public class LoginDao {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion cn = new Conexion(); // Conexión a la base de datos

    /**
     * Autentica a un usuario con el correo y la contraseña proporcionados.
     * 
     * @param correo Correo electrónico del usuario.
     * @param pass Contraseña del usuario.
     * @return Un objeto de tipo {@link login} con la información del usuario si
     *         la autenticación es exitosa, de lo contrario un objeto vacío.
     */
    public login log(String correo, String pass) {
        login l = new login();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Si se encuentra el usuario, se asignan sus valores
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setApellido(rs.getString("apellido"));
                l.setCorreo(rs.getString("correo"));
                l.setCelular(rs.getInt("celular"));
                l.setDni(rs.getInt("dni"));
                l.setGenero(rs.getString("genero"));
                l.setDireccion(rs.getString("direccion"));
                l.setPass(rs.getString("pass"));
                l.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l; // Retorna el objeto login con los datos del usuario autenticado
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     * 
     * @param reg Objeto {@link login} que contiene la información del usuario a
     *            registrar.
     * @return true si el registro fue exitoso, false en caso contrario.
     */
    public boolean Registrar(login reg) {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, celular, dni, genero, direccion, pass, rol) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getApellido());
            ps.setString(3, reg.getCorreo());
            ps.setInt(4, reg.getCelular());
            ps.setInt(5, reg.getDni());
            ps.setString(6, reg.getGenero());
            ps.setString(7, reg.getDireccion());
            ps.setString(8, reg.getPass());
            ps.setString(9, reg.getRol());
            ps.execute(); // Ejecuta la inserción en la base de datos
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * Obtiene una lista de todos los usuarios registrados en la base de datos.
     * 
     * @return Una lista de objetos {@link login} con todos los usuarios.
     */
    public List<login> ListarUsuarios() {
        List<login> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                login lg = new login();
                lg.setId(rs.getInt("id"));
                lg.setNombre(rs.getString("nombre"));
                lg.setApellido(rs.getString("apellido"));
                lg.setCorreo(rs.getString("correo"));
                lg.setPass(rs.getString("pass"));
                lg.setCelular(rs.getInt("celular"));
                lg.setDni(rs.getInt("dni"));
                lg.setGenero(rs.getString("genero"));
                lg.setDireccion(rs.getString("direccion"));
                lg.setRol(rs.getString("rol"));
                lista.add(lg); // Agrega cada usuario a la lista
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista; // Retorna la lista de usuarios
    }

    /**
     * Obtiene una lista de usuarios cuyo nombre contiene el valor especificado.
     * 
     * @param valor El valor a buscar en el nombre de los usuarios.
     * @return Una lista de objetos {@link login} con los usuarios que coinciden
     *         con la búsqueda.
     */
    public List<login> listar(String valor) {
        List<login> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE nombre LIKE ?"; // Consulta SQL para buscar usuarios por nombre
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + valor + "%"); // Usa LIKE para buscar coincidencias parciales
            rs = ps.executeQuery();

            while (rs.next()) {
                login lg = new login();
                lg.setId(rs.getInt("id"));
                lg.setNombre(rs.getString("nombre"));
                lg.setApellido(rs.getString("apellido"));
                lg.setCorreo(rs.getString("correo"));
                lg.setPass(rs.getString("pass"));
                lg.setCelular(rs.getInt("celular"));
                lg.setDni(rs.getInt("dni"));
                lg.setGenero(rs.getString("genero"));
                lg.setDireccion(rs.getString("direccion"));
                lg.setRol(rs.getString("rol"));
                lista.add(lg); // Agrega cada usuario a la lista
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close(); // Cierra la conexión a la base de datos
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return lista; // Retorna la lista de usuarios encontrados
    }

    /**
     * Actualiza la información de un usuario registrado en la base de datos.
     * 
     * @param usuario Objeto {@link login} con los nuevos datos del usuario.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public boolean EditarUsuario(login usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, correo = ?, celular = ?, dni = ?, genero = ?, direccion = ?, pass = ?, rol = ? WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setInt(4, usuario.getCelular());
            ps.setInt(5, usuario.getDni());
            ps.setString(6, usuario.getGenero());
            ps.setString(7, usuario.getDireccion());
            ps.setString(8, usuario.getPass());
            ps.setString(9, usuario.getRol());
            ps.setInt(10, usuario.getId());
            return ps.executeUpdate() > 0; // Devuelve true si se actualizó al menos un registro
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * Elimina un usuario registrado de la base de datos.
     * 
     * @param id El ID del usuario a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean EliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0; // Devuelve true si se eliminó al menos un registro
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}