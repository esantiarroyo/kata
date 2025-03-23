package com.kata.co;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    // Ruta del archivo Excel que contiene los datos de prueba
    private static final String FILE_PATH = "src/test/resources/data/credenciales.xlsx"; // Ruta del archivo

    //Método para obtener un dato específico de una celda en el archivo Excel.
    public static String getData(int row, int col) {
        String cellValue = ""; // Variable para almacenar el valor de la celda
        // Abrimos el archivo Excel para lectura
        try (FileInputStream fis = new FileInputStream(new File(FILE_PATH));
             Workbook workbook = new XSSFWorkbook(fis)) {  // Cargamos el libro de trabajo en memoria

            Sheet sheet = workbook.getSheetAt(0); // Tomamos la primera hoja
            Row excelRow = sheet.getRow(row); // Obtenemos la fila específica
            Cell cell = excelRow.getCell(col); // Obtenemos la celda específica dentro de la fila

            // Si la celda no está vacía, extraemos su contenido como texto
            if (cell != null) {
                cellValue = cell.getStringCellValue();
            }
        } catch (IOException e) {
            e.printStackTrace();  // En caso de error, imprimimos el stack trace
        }
        return cellValue; // Devolvemos el valor de la celda obtenida
    }
}
