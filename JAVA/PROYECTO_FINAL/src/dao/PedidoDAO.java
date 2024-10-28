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
import modelo.Pedido;
import conf.Conexion;
import java.util.List;
import modelo.DetallePedido;
import modelo.Sala;
/**
 *
 * @author YARDY
 */
public class PedidoDAO {
    
    private Connection con;
    private Conexion cn = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;

    public int obtenerIdPedido() {
        int id = 0;
        String sql = "SELECT MAX(id_pedido) FROM pedido";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return id;
    }

    public int verificarEstado(int mesa, int id_sala) {
        int id_pedido = 0;
        String sql = "SELECT id_pedido FROM pedido WHERE num_mesa=? AND id_sala=? AND estado = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa);
            ps.setInt(2, id_sala);
            ps.setString(3, "PENDIENTE");
            rs = ps.executeQuery();
            if (rs.next()) {
                id_pedido = rs.getInt("id_pedido");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return id_pedido;
    }

     public int registrarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (id_sala, num_mesa, total, usuario) VALUES (?,?,?,?)";
        int resultado = 0;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getId_sala().getId_sala());
            ps.setInt(2, pedido.getNum_mesa());
            ps.setDouble(3, pedido.getTotal());
            ps.setString(4, pedido.getUsuario());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return resultado;
    }

    public List<Pedido> listarPedidos() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT p.*, s.nombre FROM pedido p INNER JOIN sala s ON p.id_sala = s.id_sala ORDER BY p.fecha DESC";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId_pedido(rs.getInt("id_pedido"));
                pedido.setId_sala(new Sala(rs.getInt("id_sala"), rs.getString("nombre"), rs.getInt("num_mesa")));
                pedido.setNum_mesa(rs.getInt("num_mesa"));
                pedido.setFecha(rs.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                pedido.setTotal(rs.getDouble("total"));
                pedido.setUsuario(rs.getString("usuario"));
                pedido.setEstado(rs.getString("estado"));
                lista.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return lista;
    }

     public boolean actualizarEstado(int id_pedido) {
        String sql = "UPDATE pedido SET estado = ? WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "FINALIZADO");
            ps.setInt(2, id_pedido);
            ps.executeUpdate();
            return true;
        } catch ( SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean eliminarPedido(int id_pedido) {
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_pedido);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public Pedido obtenerPedido(int id_pedido) {
        Pedido pedido = new Pedido();
        String sql = "SELECT p.*, s.nombre FROM pedido p INNER JOIN sala s ON p.id_sala = s.id_sala WHERE p.id_pedido = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_pedido);
            rs = ps.executeQuery();
            if (rs.next()) {
                pedido.setId_pedido(rs.getInt("id_pedido"));
                pedido.setId_sala(new Sala(rs.getInt("id_sala"), rs.getString("nombre"), rs.getInt("num_mesa")));
                pedido.setNum_mesa(rs.getInt("num_mesa"));
                pedido.setFecha(rs.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                pedido.setTotal(rs.getDouble("total"));
                pedido.setUsuario(rs.getString("usuario"));
                pedido.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return pedido;
    }

    public List<Pedido> listarPedidosPorSala(int id_sala) {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT p.*, s.nombre FROM pedido p INNER JOIN sala s ON p.id_sala = s.id_sala WHERE p.id_sala = ? ORDER BY p.fecha DESC";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_sala);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId_pedido(rs.getInt("id_pedido"));
                pedido.setId_sala(new Sala(rs.getInt("id_sala"), rs.getString("nombre"), rs.getInt("num_mesa")));
                pedido.setNum_mesa(rs.getInt("num_mesa"));
                pedido.setFecha(rs.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                pedido.setTotal(rs.getDouble("total"));
                pedido.setUsuario(rs.getString("usuario"));
                pedido.setEstado(rs.getString("estado"));
                lista.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return lista;
    }

    public List<Pedido> listarPedidosPorEstado(String estado) {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT p.*, s.nombre FROM pedido p INNER JOIN sala s ON p.id_sala = s.id_sala WHERE p.estado = ? ORDER BY p.fecha DESC";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId_pedido(rs.getInt("id_pedido"));
                pedido.setId_sala(new Sala(rs.getInt("id_sala"), rs.getString("nombre"), rs.getInt("num_mesa")));
                pedido.setNum_mesa(rs.getInt("num_mesa"));
                pedido.setFecha(rs.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                pedido.setTotal(rs.getDouble("total"));
                pedido.setUsuario(rs.getString("usuario"));
                pedido.setEstado(rs.getString("estado"));
                lista.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return lista;
    }
    
    public List<DetallePedido> verPedidoDetalle(int id_pedido) {
        List<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT dp.*, p.id_pedido FROM detalle_pedido dp INNER JOIN pedido p ON dp.id_pedido = p.id_pedido WHERE dp.id_pedido = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt (1, id_pedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido detallePedido = new DetallePedido();
                detallePedido.setId_detallepedido(rs.getInt("id_detallepedido"));
                detallePedido.setNombre(rs.getString("nombre"));
                detallePedido.setPrecio(rs.getDouble("precio"));
                detallePedido.setCantidad(rs.getInt("cantidad"));
                detallePedido.setComentario(rs.getString("comentario"));
           
                lista.add(detallePedido);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return lista;
    }

}
