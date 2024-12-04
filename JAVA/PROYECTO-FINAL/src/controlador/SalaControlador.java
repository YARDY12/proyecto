/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.List;
import dao.SalaDAO;
import modelo.Sala;
import vista.FrmCevicheria;
/**
 * Clase encargada de controlar las operaciones relacionadas con las salas en el
 * sistema. Se encarga de interactuar con la vista (FrmCevicheria) y el DAO (SalaDAO)
 * para gestionar la creación, actualización, eliminación, y visualización de salas.
 */
public class SalaControlador {
    
    private FrmCevicheria vista;
    private SalaDAO dao;

    /**
     * Constructor que inicializa el controlador con la vista y el DAO.
     * 
     * @param vista Objeto {@link FrmCevicheria} que representa la vista de la sala.
     */
    public SalaControlador(FrmCevicheria vista) {
        this.vista = vista;
        this.dao = new SalaDAO();
        this.vista.setControlador(this); // Asocia el controlador con la vista
    }

    /**
     * Agrega una nueva sala al sistema con el nombre y el número de mesas proporcionados.
     * 
     * @param nombre Nombre de la nueva sala.
     * @param mesas Número de mesas en la nueva sala.
     */
    public void agregarSala(String nombre, int mesas) {
        Sala sala = new Sala();
        sala.setNombre(nombre); // Asigna el nombre a la sala
        sala.setMesa(mesas);    // Asigna el número de mesas
        boolean insercionExitosa = dao.registrarSala(sala); // Registra la sala a través del DAO
    }

    /**
     * Carga todas las salas desde el DAO y las muestra en la vista.
     */
    public void cargarSalas() {
        List<Sala> salas = dao.listarSalas(); // Obtiene la lista de todas las salas
        // Aquí podría añadirse código para actualizar la vista con la lista de salas
    }

    /**
     * Actualiza los detalles de una sala existente en el sistema.
     * 
     * @param id_sala ID de la sala que se va a actualizar.
     * @param nombre Nuevo nombre para la sala.
     * @param mesas Nuevo número de mesas para la sala.
     */
    public void actualizarSala(int id_sala, String nombre, int mesas) {
        Sala sala = new Sala(id_sala, nombre, mesas); // Crea un objeto Sala con los nuevos datos
        boolean actualizacionExitosa = dao.modificarSala(sala); // Modifica la sala a través del DAO
    }

    /**
     * Elimina una sala del sistema por su ID.
     * 
     * @param id_sala ID de la sala que se desea eliminar.
     */
    public void eliminarSala(int id_sala) {
        boolean eliminacionExitosa = dao.eliminarSala(id_sala); // Elimina la sala a través del DAO
    }

    /**
     * Busca una sala por su ID y la muestra en la vista si se encuentra.
     * 
     * @param id_sala ID de la sala que se desea buscar.
     */
    public void buscarSalaPorId(int id_sala) {
        List<Sala> salas = dao.listarSalas(); // Obtiene la lista de todas las salas
        Sala salaEncontrada = salas.stream()
                                   .filter(s -> s.getId_sala() == id_sala) // Busca la sala por ID
                                   .findFirst()
                                   .orElse(null); // Retorna null si no encuentra la sala
        // Aquí podría añadirse código para actualizar la vista con la sala encontrada
    }
}