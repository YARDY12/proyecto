package modelo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase personalizada para renderizar las celdas de una tabla (JTable).
 * Modifica el color de fondo y el color de texto de las celdas basándose en el
 * valor de la columna de estado del pedido (columna 6).
 *
 * <p>
 * Cuando el valor en la columna 6 es "PENDIENTE", el fondo de la celda se
 * establece en rojo y el texto en blanco. Cuando el valor es "FINALIZADO", el
 * fondo se establece en verde oscuro y el texto en blanco. En otros casos, el
 * fondo y el texto tienen los colores predeterminados.</p>
 *
 * @author YARDY
 */
public class Tables extends DefaultTableCellRenderer {

    /**
     * Sobrescribe el método de renderización de celdas para aplicar colores
     * personalizados basados en el valor de la columna de estado (columna 6).
     *
     * @param jtable La tabla (JTable) en la que se está renderizando la celda.
     * @param o El valor que contiene la celda que se va a renderizar.
     * @param bln Si la celda está seleccionada o no.
     * @param bln1 Si la celda tiene el foco o no.
     * @param row El índice de la fila de la celda que se está renderizando.
     * @param col El índice de la columna de la celda que se está renderizando.
     * @return El componente (celda) con los colores actualizados.
     */
    @Override
    public Component getTableCellRendererComponent(
            JTable jtable, Object o, boolean bln, boolean bln1, int row, int col) {
        // Llamar al método de la clase padre para la renderización estándar
        super.getTableCellRendererComponent(jtable, o, bln, bln1, row, col);

        // Cambiar el color de fondo y el color del texto dependiendo del valor de la columna 6
        switch (jtable.getValueAt(row, 6).toString()) {
            case "PENDIENTE":
                setBackground(new Color(255, 51, 51));  // Rojo para "PENDIENTE"
                setForeground(Color.white);  // Texto blanco
                break;
            case "FINALIZADO":
                setBackground(new Color(0, 102, 102));  // Verde oscuro para "FINALIZADO"
                setForeground(Color.white);  // Texto blanco
                break;
            default:
                setBackground(Color.white);  // Fondo blanco para otros estados
                setForeground(Color.black);  // Texto negro
                break;
        }
        return this;  // Devolver el componente (celda) con los cambios aplicados
    }
}
