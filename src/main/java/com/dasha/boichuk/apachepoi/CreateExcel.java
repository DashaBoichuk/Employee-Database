package com.dasha.boichuk.apachepoi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.dasha.boichuk.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class CreateExcel {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void saveIt(ObservableList<Employee> usersData) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");

        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("ID");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("First Name");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Last Name");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Patronymic");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Date Of Birth");
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Position");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Department");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Room Number");
        cell.setCellStyle(style);

        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("Office Phone");
        cell.setCellStyle(style);

        cell = row.createCell(9, CellType.STRING);
        cell.setCellValue("Business Email");
        cell.setCellStyle(style);

        cell = row.createCell(10, CellType.STRING);
        cell.setCellValue("Monthly Salary");
        cell.setCellStyle(style);

        cell = row.createCell(11, CellType.STRING);
        cell.setCellValue("Date Of Hiring");
        cell.setCellStyle(style);

        cell = row.createCell(12, CellType.STRING);
        cell.setCellValue("FieldForNotes");
        cell.setCellStyle(style);


        // Data
        for (Employee emp : usersData) {
            rownum++;
            row = sheet.createRow(rownum);


            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(emp.getId());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(emp.getFirstName());

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(emp.getLastName());

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(emp.getPatronymic());

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(emp.getDateOfBirth());

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(emp.getPosition());

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(emp.getDepartment());

            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(emp.getRoomNumber());

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(emp.getOfficePhone());

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue(emp.getBusinessEmail());

            cell = row.createCell(10, CellType.NUMERIC);
            cell.setCellValue(emp.getMonthlySalary());

            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue(emp.getDateOfHiring());

            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue(emp.getFieldForNotes());
            // Bonus (E)
         /*   String formula = "0.1*C" + (rownum + 1) + "*D" + (rownum + 1);
            cell = row.createCell(4, CellType.FORMULA);
            cell.setCellFormula(formula);*/
        }
        File file = new File("D:\\JavaCore Softserve\\ProjectBoychukD\\employee.xls");
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());

    }

}
