/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspeedtest.util;

import javaspeedtest.data.Speed;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaspeedtest.Benchmark;

/**
 *
 * @author HsuYi
 */
public class BenchmarkUtil {
    
    public static void writeToCSV(float downloadSpeed,String filename) {
            PrintWriter printWriter = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String downloadDate = simpleDateFormat.format(new Date());
           try {
                printWriter = new PrintWriter(new FileWriter(filename,true));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(downloadSpeed);
                stringBuilder.append(',');
                stringBuilder.append(downloadDate);
                stringBuilder.append('\n');
                printWriter.append(stringBuilder.toString());
                printWriter.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Benchmark.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Benchmark.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                printWriter.close();
            } 
        }
        
        public static float averageSpeedofDay(String date,String fileName) {
            BufferedReader br = null;
            try {
                String line = "";
                String cvsSplitBy = ",";
                int count = 0;
                float totalSpeed = 0;
                float averageSpeed = 0;
                br = new BufferedReader(new FileReader(fileName));
                while ((line = br.readLine()) != null) {
                    // use comma as separator
                    String[] speedOfDay = line.split(cvsSplitBy);
                    float speed = Float.valueOf(speedOfDay[0]);
                    String dateCSV = speedOfDay[1];
                    if(dateCSV.contains(date)) {
                        totalSpeed +=speed;
                        count++;
                    }
                }
                averageSpeed = totalSpeed/count;
                return averageSpeed;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Benchmark.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Benchmark.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Benchmark.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return 0;
        }
        
        public static List<Speed> speedsOfDay(String date,String fileName) {
            BufferedReader br = null;
            try {
                List<Speed> speeds = new ArrayList<>();
                String line = "";
                String cvsSplitBy = ",";
                br = new BufferedReader(new FileReader(fileName));
                while ((line = br.readLine()) != null) {
                    // use comma as separator
                    String[] speedOfDay = line.split(cvsSplitBy);
                    float speedCSV = Float.valueOf(speedOfDay[0]);
                    String dateCSV = speedOfDay[1];
                    if(dateCSV.contains(date)) {
                        Speed speed = new Speed();
                        speed.setDate(dateCSV);
                        speed.setSpeed(speedCSV);
                        speeds.add(speed);
                    }
                }   return speeds;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Benchmark.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Benchmark.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Benchmark.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return null;
        }
    
}
