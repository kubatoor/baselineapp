package com.i2e.baselineapp.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.i2e.baselineapp.model.Application;
import com.i2e.baselineapp.model.Project;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.i2e.baselineapp.model.Release;

/**
 * Created by anirudh on 23/10/14.
 */
public class BaseLineExcelGenerator {
    private static final String FILE_PATH = "C:/Work/BASELINES_IHS WAS8_Consumer Cell.xlsx";
    //We are making use of a single instance to prevent multiple write access to same file.
    private static final BaseLineExcelGenerator INSTANCE = new BaseLineExcelGenerator();

    public static BaseLineExcelGenerator getInstance() {
        return INSTANCE;
    }

    private BaseLineExcelGenerator() {
    }

    public static Workbook generateBaseLine(List<Release> releases ){

        // Using XSSF for xlsx format, for xls use HSSF
        Workbook workbook = new XSSFWorkbook();

        Sheet baselineSheet = workbook.createSheet("Sheet1");

        int rowIndex = 0;
        //for(Release release : releases){
        Row row = baselineSheet.createRow(rowIndex++);
        int cellIndex = 0;

        row.createCell(cellIndex++).setCellValue("#");
        row.createCell(cellIndex++).setCellValue("Project Name");
        row.createCell(cellIndex++).setCellValue("Final Baseline");
        row.createCell(cellIndex++).setCellValue("JVM Instance");
        row.createCell(cellIndex++).setCellValue("EAR file");
        row.createCell(cellIndex++).setCellValue("File Path");
        row.createCell(cellIndex++).setCellValue("WebModule");
        row.createCell(cellIndex++).setCellValue("Are there any new EJB modules as part of this project");
        row.createCell(cellIndex++).setCellValue("New EJB modules");
        row.createCell(cellIndex++).setCellValue("Regen global plugin");
        row.createCell(cellIndex++).setCellValue("WebSphere cell name");
        row.createCell(cellIndex++).setCellValue("Other Info");
        row.createCell(cellIndex++).setCellValue("WebServer Mapping");

        for (Release release:releases){
            for (Project project:release.getProjects()){
                for (Application app:project.getApplications()){
                    cellIndex = 0;
                    row = baselineSheet.createRow(rowIndex++);
                    row.createCell(cellIndex++).setCellValue(rowIndex-1);
                    row.createCell(cellIndex++).setCellValue(project.getProjectName());
                    row.createCell(cellIndex++).setCellValue("hardcoded");
                    row.createCell(cellIndex++).setCellValue("JVM Instance");
                    row.createCell(cellIndex++).setCellValue("EAR file");
                    row.createCell(cellIndex++).setCellValue("File Path");
                    row.createCell(cellIndex++).setCellValue("WebModule");
                    row.createCell(cellIndex++).setCellValue("no");
                    row.createCell(cellIndex++).setCellValue("no");
                    row.createCell(cellIndex++).setCellValue("no");
                    row.createCell(cellIndex++).setCellValue("InetMC8NAProd");
                    row.createCell(cellIndex++).setCellValue("vhost=cms_sec_virtualhost");
                    row.createCell(cellIndex++).setCellValue("cardmember-sec-21200");
                }
            }
        }

        return workbook;
    }
}
