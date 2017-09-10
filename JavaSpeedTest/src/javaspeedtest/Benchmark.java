package javaspeedtest;

import javaspeedtest.util.BenchmarkUtil;
import javaspeedtest.data.Speed;
import java.io.BufferedReader;
import java.io.File;
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

public class Benchmark {
	
	public void hourly() {
                SpeedTest speedTest = new SpeedTest();
                float downloadSpeed = speedTest.download_speed();
                BenchmarkUtil.writeToCSV(downloadSpeed, "DownloadSpeed.csv");
                float uploadSpeed = speedTest.upload_speed();
                BenchmarkUtil.writeToCSV(uploadSpeed,"UploadSpeed.csv");
                float ping = speedTest.ping(); 
                BenchmarkUtil.writeToCSV(ping,"Ping.csv");
	}
        
        public float download_average(String date) {
            float averageDownloadSpeed = BenchmarkUtil.averageSpeedofDay(date, "DownloadSpeed.csv");
            return averageDownloadSpeed;
        }
        
        public float upload_average(String date){
            float averageUploadSpeed = BenchmarkUtil.averageSpeedofDay(date, "UploadSpeed.csv");
            return averageUploadSpeed;
        }
        
        public float ping_average(String date) {
            float averagePing = BenchmarkUtil.averageSpeedofDay(date, "Ping.csv");
            return averagePing;
        }
        
        public List<Speed> downloads(String date) {
            List<Speed> downloadSpeeds = BenchmarkUtil.speedsOfDay(date,"DownloadSpeed.csv");
            return downloadSpeeds;
        }
        
        public List<Speed> uploads(String date) {
            List<Speed> uploadSpeeds = BenchmarkUtil.speedsOfDay(date,"UploadSpeed.csv");
            return uploadSpeeds;
        }
        
        public List<Speed> pings(String date) {
            List<Speed> pings = BenchmarkUtil.speedsOfDay(date,"Ping.csv");
            return pings;
        }
}
