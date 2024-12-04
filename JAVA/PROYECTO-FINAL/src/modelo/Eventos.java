package modelo;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 * Clase que gestiona eventos de teclado para campos de texto. Proporciona
 * métodos para filtrar la entrada de caracteres en los campos de texto,
 * permitiendo solo letras, números, y números decimales, según el contexto.
 *
 * <p>
 * Los métodos de esta clase se pueden usar para restringir la entrada del
 * usuario en los campos de texto para ciertos tipos de datos, como solo letras,
 * solo números o números decimales.</p>
 *
 * @author YARDY
 */
public class Eventos {

    /**
     * Método que filtra la entrada de texto para permitir solo letras y
     * espacio. Si el usuario intenta ingresar un carácter que no sea una letra
     * (mayúscula o minúscula) o un espacio, el evento es consumido y no se
     * ingresa el carácter.
     *
     * @param evt El evento de teclado que se genera cuando una tecla es
     * presionada.
     */
    public void textKeyPress(KeyEvent evt) {
        // declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();  // Eliminar la entrada de caracteres no válidos
        }
    }

    /**
     * Método que filtra la entrada de texto para permitir solo números. Si el
     * usuario intenta ingresar un carácter que no sea un número o el símbolo de
     * retroceso, el evento es consumido y no se ingresa el carácter.
     *
     * @param evt El evento de teclado que se genera cuando una tecla es
     * presionada.
     */
    public void numberKeyPress(KeyEvent evt) {
        // declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // Eliminar la entrada de caracteres no válidos
        }
    }

    /**
     * Método que filtra la entrada de texto para permitir solo números
     * decimales. Si el usuario intenta ingresar un carácter que no sea un
     * número o el símbolo de punto decimal, o si ya se ha ingresado un punto,
     * el evento es consumido y no se ingresa el carácter.
     *
     * @param evt El evento de teclado que se genera cuando una tecla es
     * presionada.
     * @param textField El campo de texto donde se está realizando la entrada.
     */
    public void numberDecimalKeyPress(KeyEvent evt, JTextField textField) {
        // declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && textField.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // Eliminar la entrada de caracteres no válidos
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  // Eliminar la entrada de caracteres no válidos
        }
    }
}
