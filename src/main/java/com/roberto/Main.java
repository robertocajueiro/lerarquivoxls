package com.roberto;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        try {
            FileInputStream file = new FileInputStream("livros.xls");
            HSSFWorkbook planilha = new HSSFWorkbook(file);
            HSSFSheet livros = planilha.getSheetAt(0);
            Iterator<Row> itLinha = livros.iterator();
            int total = 0;
            Row linha = itLinha.next();
            while (itLinha.hasNext()) {
                linha = itLinha.next();
                total++;
                Iterator<Cell> celIt = linha.cellIterator();
                System.out.print("Livro: "+total);
                while (celIt.hasNext()) {
                    Cell celula = celIt.next();
                    switch (celula.getColumnIndex()) {
                        case 0:
                            System.out.print(" Código: " + celula.getNumericCellValue());
                            break;
                        case 1:
                            System.out.println(" Titulo: " + celula.getStringCellValue());
                            break;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}