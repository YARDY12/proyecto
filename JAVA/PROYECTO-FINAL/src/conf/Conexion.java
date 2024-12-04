/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos MySQL.
 *
 * Esta clase proporciona un método para establecer y obtener una conexión con
 * una base de datos MySQL a través de JDBC. La base de datos utilizada en este
 * caso es "cevicheria" en el servidor local (localhost).
 *
 * @author YARDY
 */
public class Conexion {

    private Connection con;  // Variable que almacena la conexión a la base de datos

    /**
     * Establece y obtiene una conexión con la base de datos MySQL.
     *
     * Este método establece una conexión utilizando el controlador JDBC para
     * MySQL. La conexión se establece con el nombre de la base de datos
     * "cevicheria", el usuario "root", y sin una contraseña.
     *
     * @return Un objeto {@link Connection} si la conexión es exitosa, o null si
     * ocurre un error.
     */
    public Connection getConnection() {
        try {
            // URL de conexión a la base de datos "cevicheria" en el servidor local
            String myBD = "jdbc:mysql://localhost:3306/cevicheria";
            // Establecer la conexión utilizando el controlador JDBC para MySQL
            con = DriverManager.getConnection(myBD, "root", "");
            return con;  // Retornar la conexión establecida
        } catch (SQLException e) {
            // Si ocurre un error, imprimir el mensaje de error
            System.out.println(e.toString());
        }
        return null;  // Retornar null si la conexión falla
    }
}
