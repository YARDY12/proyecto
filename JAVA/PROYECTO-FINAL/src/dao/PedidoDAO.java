package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pedido;
import conf.Conexion;
import java.util.List;
import modelo.DetallePedido;
import modelo.Sala;

/**
 * Clase encargada de gestionar las operaciones de la base de datos relacionadas con los pedidos y sus detalles.
 * Contiene métodos para registrar, actualizar, obtener y eliminar pedidos y detalles de pedidos.
 */
public class PedidoDAO {

    private Connection con;
    private Conexion cn = new Conexion(); // Conexión a la base de datos

    /**
     * Obtiene el último ID de pedido registrado en la base de datos.
     * 
     * @return El último ID de pedido.
     */
    public int obtenerUltimoIdPedido() {
        int id = 0;
        String sql = "SELECT MAX(id_pedido) FROM pedido";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo el último ID de pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return id;
    }

    /**
     * Verifica si existe un pedido con estado 'PENDIENTE' para una mesa y sala específicos.
     * 
     * @param mesa Número de la mesa.
     * @param idSala ID de la sala.
     * @return El ID del pedido si existe, 0 si no.
     */
    public int verificarEstadoPedido(int mesa, int idSala) {
        int idPedido = 0;
        String sql = "SELECT id_pedido FROM pedido WHERE num_mesa = ? AND id_sala = ? AND estado = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesa);
            ps.setInt(2, idSala);
            ps.setString(3, "PENDIENTE");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idPedido = rs.getInt("id_pedido");
            }
        } catch (SQLException e) {
            System.out.println("Error verificando el estado del pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return idPedido;
    }

    /**
     * Verifica si existe un detalle de pedido con estado 'EN PROCESO' para un pedido específico.
     * 
     * @param idPedido El ID del pedido a verificar.
     * @return true si existe un detalle en estado 'EN PROCESO', false si no.
     */
    public boolean verificarEstadoDetallePedido(int idPedido) {
        boolean existePendiente = false;
        String sql = "SELECT id FROM detalle_pedido WHERE id_pedido = ? AND estado = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);  // ID del pedido
            ps.setString(2, "EN PROCESO"); // Estado a verificar
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existePendiente = true; // Si hay un registro, devuelve true
            }
        } catch (SQLException e) {
            System.out.println("Error verificando el estado de detalle_pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return existePendiente;
    }

    /**
     * Actualiza el estado de un pedido a 'FINALIZADO'.
     * 
     * @param id_pedido El ID del pedido a actualizar.
     * @return true si se actualizó correctamente, false si ocurrió un error.
     */
    public boolean actualizarEstado(int id_pedido) {
        String sql = "UPDATE pedido SET estado = ? WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "FINALIZADO");
            ps.setInt(2, id_pedido);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado: " + e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.toString());
            }
        }
    }

    /**
     * Registra un nuevo pedido en la base de datos.
     * 
     * @param pedido El objeto Pedido que contiene la información del pedido.
     * @return El ID del pedido registrado, o 0 si ocurrió un error.
     */
    public int registrarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (id_sala, num_mesa, total, usuario) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getId_sala());
            ps.setInt(2, pedido.getNum_mesa());
            ps.setDouble(3, pedido.getTotal());
            ps.setString(4, pedido.getUsuario());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Error registrando el pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return 1;
    }

    /**
     * Verifica si todos los detalles de un pedido han sido realizados (estado 'REALIZADO').
     * 
     * @param id_pedido El ID del pedido a verificar.
     * @return true si todos los detalles están 'REALIZADO', false si hay detalles pendientes.
     */
    public boolean verificarDetallesRealizados(int id_pedido) {
        String sql = "SELECT COUNT(*) FROM detalle_pedido WHERE id_pedido = ? AND estado != 'REALIZADO'";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_pedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error al verificar detalles del pedido: " + e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.toString());
            }
        }
    }

    /**
     * Registra un nuevo detalle de pedido en la base de datos.
     * 
     * @param detalle El objeto DetallePedido que contiene la información del detalle.
     * @return El número de filas afectadas (1 si se insertó correctamente, 0 si falló).
     */
    public int registrarDetallePedido(DetallePedido detalle) {
        String sql = "INSERT INTO detalle_pedido (nombre, tipoPlato, precio, cantidad, comentario, id_pedido) VALUES (?, ?, ?, ?, ?, ?)";
        int resultado = 0; // Indicador de éxito
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, detalle.getNombre());
            ps.setString(2, detalle.getTipoPlato());
            ps.setDouble(3, detalle.getPrecio());
            ps.setInt(4, detalle.getCantidad());
            ps.setString(5, detalle.getComentario());
            ps.setInt(6, detalle.getId_pedido());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error registrando el detalle del pedido: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.getMessage());
            }
        }
        return resultado;
    }

    /**
     * Obtiene todos los detalles de un pedido específico.
     * 
     * @param idPedido El ID del pedido para el cual se obtendrán los detalles.
     * @return Una lista de objetos DetallePedido asociados al pedido.
     */
    public List<DetallePedido> obtenerDetallesPedido(int idPedido) {
        List<DetallePedido> listaDetalles = new ArrayList<>();
        String sql = "SELECT * FROM detalle_pedido WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido); // Establece el ID del pedido como parámetro
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetallePedido detalle = new DetallePedido();
                detalle.setId_detallepedido(rs.getInt("id"));
                detalle.setNombre(rs.getString("nombre"));
                detalle.setTipoPlato(rs.getString("tipoPlato"));
                detalle.setPrecio(rs.getDouble("precio"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setComentario(rs.getString("comentario"));
                detalle.setId_pedido(rs.getInt("id_pedido"));
                detalle.setEstado(rs.getString("estado"));

                listaDetalles.add(detalle);
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo detalles del pedido: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.getMessage());
            }
        }
        return listaDetalles;
    }

    /**
     * Obtiene un pedido por su ID.
     * 
     * @param idPedido El ID del pedido a obtener.
     * @return El objeto Pedido correspondiente, o null si no existe.
     */
    public Pedido obtenerPedido(int idPedido) {
        Pedido pedido = null;
        String sql = "SELECT p.id_pedido, p.fecha, p.total, p.estado, p.usuario, p.id_sala, p.num_mesa, s.nombre AS sala "
                + "FROM pedido p "
                + "INNER JOIN sala s ON p.id_sala = s.id_sala "
                + "WHERE p.id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setFecha(rs.getString("fecha"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setEstado(rs.getString("estado"));
                pedido.setUsuario(rs.getString("usuario"));
                pedido.setId_sala(rs.getInt("id_sala"));
                pedido.setNum_mesa(rs.getInt("num_mesa"));
                pedido.setSala(rs.getString("sala"));
            }
        } catch (SQLException e) {
            System.out.println("Error obteniendo el pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return pedido;
    }

    /**
     * Finaliza un pedido cambiando su estado a 'FINALIZADO'.
     * 
     * @param idPedido El ID del pedido a finalizar.
     * @return true si se actualizó correctamente, false si ocurrió un error.
     */
    public boolean finalizarPedido(int idPedido) {
        String sql = "UPDATE pedido SET estado = 'FINALIZADO' WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error finalizando el pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return false;
    }

    /**
     * Cambia el estado de un detalle de pedido.
     * 
     * @param idDetalle El ID del detalle de pedido.
     * @param nuevoEstado El nuevo estado para el detalle de pedido.
     * @return true si se actualizó correctamente, false si ocurrió un error.
     */
    public boolean cambiarEstadoDetalle(int idDetalle, String nuevoEstado) {
        String sql = "UPDATE detalle_pedido SET estado = ? WHERE id = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoEstado); // Estado nuevo ("REALIZADO")
            ps.setInt(2, idDetalle);      // ID del detalle_pedido
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error cambiando el estado del detalle_pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return false;
    }

    /**
     * Lista todos los pedidos registrados.
     * 
     * @return Una lista de objetos Pedido con todos los registros de la tabla 'pedido'.
     */
    public List<Pedido> listarPedidos() {
        List<Pedido> listaPedidos = new ArrayList<>();
        String sql = "SELECT p.id_pedido, p.fecha, p.total, p.estado, p.usuario, s.nombre AS sala, p.num_mesa, p.id_sala "
                + "FROM pedido p "
                + "INNER JOIN sala s ON p.id_sala = s.id_sala ORDER BY p.fecha DESC";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id_pedido"));
                pedido.setFecha(rs.getString("fecha"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setEstado(rs.getString("estado"));
                pedido.setUsuario(rs.getString("usuario"));
                pedido.setSala(rs.getString("sala"));
                pedido.setNum_mesa(rs.getInt("num_mesa"));
                pedido.setId_sala(rs.getInt("id_sala"));
                listaPedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error listando los pedidos: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return listaPedidos;
    }

    /**
     * Lista todos los detalles de pedidos registrados.
     * 
     * @return Una lista de objetos DetallePedido con todos los registros de la tabla 'detalle_pedido'.
     */
    public List<DetallePedido> listarDetallesPedido() {
        List<DetallePedido> listaDetalles = new ArrayList<>();
        String sql = "SELECT dp.id, dp.nombre, dp.tipoPlato, dp.precio, dp.cantidad, dp.comentario, dp.id_pedido, dp.estado "
                + "FROM detalle_pedido dp ORDER BY dp.id ASC";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido detalle = new DetallePedido();
                detalle.setId_detallepedido(rs.getInt("id"));
                detalle.setNombre(rs.getString("nombre"));
                detalle.setTipoPlato(rs.getString("tipoPlato"));
                detalle.setPrecio(rs.getDouble("precio"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setComentario(rs.getString("comentario"));
                detalle.setId_pedido(rs.getInt("id_pedido"));
                detalle.setEstado(rs.getString("estado"));
                listaDetalles.add(detalle);
            }
        } catch (SQLException e) {
            System.out.println("Error listando los detalles de pedido: " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return listaDetalles;
    }

    /**
     * Actualiza el estado de un pedido específico.
     * 
     * @param idPedido El ID del pedido a actualizar.
     * @param estado El nuevo estado para el pedido.
     * @return true si se actualizó correctamente, false si ocurrió un error.
     */
    public boolean actualizarEstadoPedido(int idPedido, String estado) {
        String sql = "UPDATE pedido SET estado = ? WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, idPedido);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error actualizando el estado del pedido: " + e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e);
            }
        }
        return false;
    }
}
