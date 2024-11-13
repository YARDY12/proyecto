/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.ProductoDAO;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author YARDY
 */
public class ProductoControlador {
     private ProductoDAO dao;

    public ProductoControlador(ProductoDAO dao) {
        this.dao = dao;
    }

    public void agregarProducto(String nom_producto, String tipoPlato, String categoria, double precio) {
        Producto producto = new Producto();
        producto.setNom_producto(nom_producto);
        producto.setTipoPlato(tipoPlato);
        producto.setCategoria(categoria);
        producto.setPrecio(precio);
        
    }

    public List<Producto> cargarProductos() {
        
         return null;
    }

    public void actualizarProducto(int id_producto, String nom_producto, String tipoPlato, String categoria, double precio) {
        Producto producto = new Producto(id_producto, nom_producto, tipoPlato, categoria, precio);
        
    }

    public void eliminarProducto(int id_producto) {
        
    }

    public Producto buscarProductoPorId(int id_producto) {
        
         return null;
    }
}
