/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

/**
 * Controlador encargado de manejar las operaciones relacionadas con los productos en el sistema.
 * Permite agregar, eliminar, actualizar y buscar productos en una lista.
 * 
 * La lista de productos actúa como una base de datos simulada.
 * 
 * @author YARDY
 */
public class ProductoControlador {
    
    // Lista de productos (simula una base de datos)
    private List<Producto> productos;

    /**
     * Constructor que inicializa la lista de productos.
     */
    public ProductoControlador() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo producto a la lista.
     * 
     * @param producto Objeto {@link Producto} que se desea agregar a la lista.
     * @return true si el producto se agrega correctamente, false si no.
     */
    public boolean agregarProducto(Producto producto) {
        return productos.add(producto);
    }

    /**
     * Elimina un producto de la lista por su ID.
     * 
     * @param id_producto ID del producto que se desea eliminar.
     * @return true si el producto se elimina correctamente, false si no se encontró el producto.
     */
    public boolean eliminarProducto(int id_producto) {
        Producto producto = buscarProductoPorId(id_producto); // Busca el producto por ID
        if (producto != null) {
            return productos.remove(producto); // Elimina el producto si existe
        }
        return false; // Retorna false si no se encontró el producto
    }

    /**
     * Actualiza un producto en la lista con los nuevos valores proporcionados.
     * 
     * @param productoActualizado Objeto {@link Producto} con los nuevos valores.
     * @return true si el producto se actualiza correctamente, false si el producto no existe.
     */
    public boolean actualizarProducto(Producto productoActualizado) {
        Producto producto = buscarProductoPorId(productoActualizado.getId_producto());
        if (producto != null) {
            producto.setNom_producto(productoActualizado.getNom_producto());
            producto.setTipoPlato(productoActualizado.getTipoPlato());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setDescripcion(productoActualizado.getDescripcion());
            return true; // Retorna true si la actualización fue exitosa
        }
        return false; // Retorna false si el producto no fue encontrado
    }

    /**
     * Busca un producto en la lista por su ID.
     * 
     * @param id_producto ID del producto que se busca.
     * @return El objeto {@link Producto} encontrado, o null si no existe.
     */
    public Producto buscarProductoPorId(int id_producto) {
        for (Producto producto : productos) {
            if (producto.getId_producto() == id_producto) {
                return producto; // Retorna el producto si se encuentra
            }
        }
        return null; // Retorna null si el producto no se encuentra
    }

    /**
     * Obtiene la lista completa de productos.
     * 
     * @return Lista de objetos {@link Producto}.
     */
    public List<Producto> obtenerProductos() {
        return productos;
    }

    /**
     * Busca productos por su nombre, permitiendo coincidencias parciales (sin distinguir mayúsculas/minúsculas).
     * 
     * @param nombre Nombre o parte del nombre del producto.
     * @return Lista de productos que coinciden con el nombre proporcionado.
     */
    public List<Producto> buscarProductoPorNombre(String nombre) {
        List<Producto> productosEncontrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getNom_producto().toLowerCase().contains(nombre.toLowerCase())) {
                productosEncontrados.add(producto); // Agrega el producto si hay coincidencia
            }
        }
        return productosEncontrados;
    }

    /**
     * Obtiene los productos filtrados por su tipo (plato).
     * 
     * @param tipoPlato Tipo de plato a buscar.
     * @return Lista de productos que corresponden al tipo especificado.
     */
    public List<Producto> obtenerProductosPorTipo(String tipoPlato) {
        List<Producto> productosPorTipo = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getTipoPlato().equalsIgnoreCase(tipoPlato)) {
                productosPorTipo.add(producto); // Agrega el producto si coincide con el tipo
            }
        }
        return productosPorTipo;
    }
}

