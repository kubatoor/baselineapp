package com.i2e.baselineapp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.i2e.baselineapp.model.Application;
import com.i2e.baselineapp.model.Project;
import com.i2e.baselineapp.model.Release;
import com.i2e.baselineapp.model.Baseline;


/**
 * Created by anirudh on 20/10/14.
 */
public class ChangeLogReader {

    private static final String FILE_PATH = "C:/I2E/CM_Active.xlsx";


/*
    public static void main(String args[]) {
        List<Release> releases = getReleases ();
        Iterator<Release> itr = releases.iterator();
        System.out.println ("Printing output");
        while (itr.hasNext()){
            Release r = itr.next();
            System.out.println (r.getReleaseDate());

            Iterator<Project> pitr = r.getProjects().iterator();
            while (pitr.hasNext()){
                Project p = pitr.next();
                System.out.println (p.getProjectID());
                System.out.println (p.getProjectName());
                Iterator<Application> apps = p.getApplications().iterator();
                while (apps.hasNext()){
                    System.out.println (apps.next().getApplicationName());
                }
            }
        }
    }
*/


    public static List<Release> getReleases() {
        FileInputStream fis = null;
        List<Release> releases = new ArrayList<Release> ();
        try {

            Release release = null;
            Project project = null;
            fis = new FileInputStream(FILE_PATH);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);

            int numberOfSheets = workbook.getNumberOfSheets();
            SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yy");
            Date prevDate = null;
            Date currDate = null;
            //looping over each workbook sheet
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator();

                int rowCount = 0;
                //iterating over each row
                while (rowIterator.hasNext()) {
                    rowCount++;
                    Row row = rowIterator.next();
                    if(rowCount==1){
                        continue;
                    }

                    Iterator<Cell> cellIterator = row.cellIterator();

                    int cellCount = 0;
                    String cell = null;
                    //Iterating over each cell (column wise)  in a particular row.
                    while (cellIterator.hasNext()) {
                        if(cellCount==0){
                            cell =  cellIterator.next().getStringCellValue();
                            if(!"".equals (cell)){
                                currDate = sdf.parse(cell);
                            }

                            if(prevDate==null || !prevDate.equals(currDate)){
                                release = new Release ();
                                releases.add(release);
                                release.setReleaseDate(cell);
                            }
                            prevDate = currDate;
                        }else if(cellCount==2){
                            cell =  cellIterator.next().getStringCellValue();
                            project = new Project ();
                            release.setProjects(new HashSet<Project>());
                            release.getProjects().add(project);
                            project.setProjectID(Long.valueOf(cell));
                        }else if(cellCount==3){
                            cell =  cellIterator.next().getStringCellValue();
                            project.setProjectName(cell);
                        }else if(cellCount==15){
                            cell =  cellIterator.next().getStringCellValue();
                            System.out.println ("..." + cell);
                            StringTokenizer st = new StringTokenizer(cell,"\n");
                            while (st.hasMoreTokens()){
                                Application app = new Application ();
                                app.setApplicationName(st.nextToken ());
                                if(project.getApplications()==null) {
                                    project.setApplications(new HashSet<Application>());
                                }
                                project.getApplications().add(app);
                            }
                        }else if(cellCount==16){
                            break;
                        }else{
                            cellIterator.next();
                        }
                        cellCount++;
                    }
                }
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return releases;
    }
}