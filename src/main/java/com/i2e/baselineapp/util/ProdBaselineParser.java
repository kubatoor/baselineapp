package com.i2e.baselineapp.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.i2e.baselineapp.model.ProdBaseline;

public class ProdBaselineParser {

/*
    public static void main(String args[]) {
        readProdBaseline("C:/I2E/baseline.txt");
    }
*/

    public static void readProdBaseline(String fileName) {
        String line = null;
        int linesRead = 0;
        int mod = 1;
        StringTokenizer st = null;
        ProdBaseline pb = null;
        //SimpleDateFormat sdf = new SimpleDateFormat ("yyyy")

        List<ProdBaseline> baselines = new ArrayList<ProdBaseline>();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                try {
                    linesRead++;
                    mod = linesRead % 8;
                    line = line.replaceAll("'", "");
                    //System.out.println (line);
                    pb = new ProdBaseline();
                    if (mod == 2) {
                        line = line.replaceAll("Application name = ", "");
                        pb.setAppName(line.trim ());
                        System.out.println (pb.getAppName());
                    } else if (mod == 5) {
                        line = line.replaceAll("CM Baseline:", "");
                        pb.setBaseline(line.trim ());
                        System.out.println (pb.getBaseline());
                    } else if (mod == 6) {
                        line = line.replaceAll("Build Timestamp:", "");
                        pb.setDate(parseDate (line.trim ()));
                        System.out.println (pb.getDate());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    public static Date parseDate (String str) throws Exception{
        //20150706-03:49:20
        //Fri Jun 12 04:31:24 2015
        Date date = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat ("yyyymmdd-HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat ("EEE MMM d HH:mm:ss yyyy");
        if(str.length()==17){
            date = sdf1.parse(str);
            //System.out.println (date);
        }else if(str.length()==24){
            date = sdf2.parse(str);
            //System.out.println (date);
        }
        return date;
    }
}
