/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import vista.FrmLogin;
/**
 * La clase Cevicheria es el punto de entrada principal de la aplicación.
 * En su método <code>main</code>, se inicializa y se muestra el formulario de inicio de sesión
 * para que el usuario pueda interactuar con la aplicación.
 * 
 * @author YARDY
 */
public class Cevicheria {

    /**
     * El método principal que arranca la aplicación.
     * Inicia el formulario de inicio de sesión <code>FrmLogin</code> y lo hace visible
     * para que el usuario pueda ingresar sus credenciales.
     * 
     * @param args Los argumentos que se pasan al iniciar la aplicación (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Se crea una instancia de FrmLogin y se hace visible
        FrmLogin iniciar = new FrmLogin();
        iniciar.setVisible(true);
    }
}
