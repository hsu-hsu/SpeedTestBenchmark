/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspeedtest;

import javaspeedtest.data.Speed;
import java.util.List;

/**
 *
 * @author HsuYi
 */
public class JavaSpeedTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Benchmark benchmark = new Benchmark();
        // TODO code application logic here
        Thread t = new Thread() {
            @Override
            public void run() {
                while(true) {
                    try {                       
                        benchmark.hourly();
                        Thread.sleep(1000*60*60); 
                    } catch (InterruptedException ie) {
                    }
                }
            }
        };
        t.start();
        float averageUpload = benchmark.upload_average("9/10/2017");
        float averageDownload = benchmark.download_average("9/10/2017");
        float averagePing = benchmark.ping_average("9/10/2017");
        
        List<Speed> downloadSpeeds = benchmark.downloads("9/10/2017");
        for(int i = 0;i<downloadSpeeds.size();i++) {
        System.out.println("Download Speed "+downloadSpeeds.get(i).getSpeed()+" Date "+downloadSpeeds.get(i).getDate());
        }
        
        List<Speed> UploadSpeed = benchmark.uploads("9/10/2017");
        for(int i = 0;i<UploadSpeed.size();i++) {
        System.out.println("Upload Speed "+UploadSpeed.get(i).getSpeed()+" Date "+UploadSpeed.get(i).getDate());
        }
        
        List<Speed> pings = benchmark.uploads("9/10/2017");
        for(int i = 0;i<pings.size();i++) {
        System.out.println("Ping "+pings.get(i).getSpeed()+" Date "+pings.get(i).getDate());
        }
    }
    
}
