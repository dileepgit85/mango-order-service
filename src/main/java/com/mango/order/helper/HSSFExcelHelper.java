package com.mango.order.helper;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class HSSFExcelHelper implements  ExcelHelperInterface {

    public ByteArrayInputStream generateExcel(ArrayList<String> headers, ArrayList<HashMap<String, String>> data) {
        System.out.println("Generating Excel");
        ByteArrayInputStream bis;
        HSSFWorkbook workbook = null;
        ByteArrayOutputStream fileOut = new ByteArrayOutputStream();
        try{
            // Create a Workbook
            workbook = new HSSFWorkbook();
            // Create a Sheet
             HSSFSheet sheet = workbook.createSheet("Sheet");
            // Create a Row
             HSSFRow headerRow = sheet.createRow(0);
            // Create cells
             for (int i = 0; i < headers.size(); i++) {
                 HSSFCell cell = headerRow.createCell(i);
                 cell.setCellValue(headers.get(i));
             }
             for (int i = 0; i < data.size(); i++) {
                 HSSFRow dataRow = sheet.createRow(i + 1);
                 for (int j = 0; j < headers.size(); j++) {
                     HSSFCell cell = dataRow.createCell(j);
                     cell.setCellValue(data.get(i).get(headers.get(j)));
                 }
             }

             workbook.write(fileOut);
             return new ByteArrayInputStream(fileOut.toByteArray());

        } catch (IOException ioe) {
            System.out.println("Error while generating excel");
        } catch (Exception e) {
            System.out.println("Error while generating excel");
        } finally {
            try {
//                bis.close();
                fileOut.close();
                if(workbook!=null) workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return null;
    }
}
