/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.List;
import dao.SalaDAO;
import modelo.Sala;
import vista.AdministradorVista;
/**
 *
 * @author YARDY
 */
public class SalaControlador {
    
    private AdministradorVista vista;
    private SalaDAO dao;

    /**
     * Constructor que inicializa el controlador con la vista y el DAO.
     * @param vista Objeto SalaVista.
     */
    public SalaControlador(AdministradorVista vista) {
        this.vista = vista;
        this.dao = new SalaDAO();
        this.vista.setControlador(this);
        
    }

    /**
     * Método para agregar una nueva sala.
     * @param nombre Nombre de la sala.
     * @param mesas Número de mesas en la sala.
     */
    public void agregarSala(String nombre, int mesas) {
        Sala sala = new Sala();
        sala.setNombre(nombre);
        sala.setMesa(mesas);
        boolean insercionExitosa = dao.registrarSala(sala);
    }

    /**
     * Método para cargar y mostrar todas las salas en la vista.
     */
    public void cargarSalas() {
        List<Sala> salas = dao.listarSalas();
    }

    /**
     * Método para actualizar una sala existente.
     * @param id_sala ID de la sala.
     * @param nombre Nuevo nombre de la sala.
     * @param mesas Nuevo número de mesas.
     */
    public void actualizarSala(int id_sala, String nombre, int mesas) {
        Sala sala = new Sala(id_sala, nombre, mesas);
        boolean actualizacionExitosa = dao.modificarSala(sala);
    }

    /**
     * Método para eliminar una sala por su ID.
     * @param id_sala ID de la sala a eliminar.
     */
    public void eliminarSala(int id_sala) {
        boolean eliminacionExitosa = dao.eliminarSala(id_sala);
    }

    /**
     * Método para obtener y mostrar una sala específica por su ID.
     * @param id_sala ID de la sala a buscar.
     */
    public void buscarSalaPorId(int id_sala) {
        List<Sala> salas = dao.listarSalas();  // Para mantener consistencia con DAO actual
        Sala salaEncontrada = salas.stream()
                                   .filter(s -> s.getId_sala() == id_sala)
                                   .findFirst()
                                   .orElse(null);
       
    }
    
        

    
}
