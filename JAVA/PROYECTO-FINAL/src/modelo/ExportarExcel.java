/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Clase que permite exportar los datos de una {@link JTable} a un archivo Excel
 * (.xls).
 *
 * <p>
 * Esta clase utiliza Apache POI para crear y escribir archivos Excel. Permite
 * al usuario elegir la ubicación y el nombre del archivo donde se guardarán los
 * datos de la tabla.</p>
 *
 * @author YARDY
 */
public class ExportarExcel {

    /**
     * Exporta los datos de la tabla proporcionada a un archivo Excel (.xls).
     *
     * El usuario selecciona la ubicación y el nombre del archivo de destino.
     * Los datos de la tabla se exportan a un archivo Excel con formato .xls. La
     * primera fila del archivo Excel contiene los nombres de las columnas y las
     * filas siguientes contienen los datos de la tabla.
     *
     * @param t La tabla ({@link JTable}) cuyos datos se exportarán.
     * @throws IOException Si ocurre un error durante la creación o escritura
     * del archivo Excel.
     */
    public void exportarExcel(JTable t) throws IOException {
        // Crear un selector de archivos para guardar el archivo Excel
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);

        // Mostrar el diálogo de guardar archivo
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                // Crear el archivo Excel
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();  // Eliminar archivo si ya existe
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();  // Crear un nuevo libro de trabajo Excel
                FileOutputStream archivo = new FileOutputStream(archivoXLS);  // Crear flujo de salida
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");  // Crear hoja en el libro
                hoja.setDisplayGridlines(false);  // Desactivar las líneas de cuadrícula

                // Escribir nombres de las columnas en la primera fila
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));  // Establecer el nombre de la columna
                        }
                    }
                }

                // Escribir los datos de la tabla a partir de la segunda fila
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));  // Para valores de tipo Double
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));  // Para valores de tipo Float
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));  // Para otros tipos de datos
                        }
                    }
                }

                // Escribir el archivo y cerrarlo
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);  // Abrir el archivo Excel creado
            } catch (IOException | NumberFormatException e) {
                throw e;  // Lanzar cualquier excepción que ocurra
            }
        }
    }
}
