package org.techtown.dontlate.model;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NetworkThreadArsId extends Thread{
    @Override
    public void run() {

        try{
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/stationinfo/getStationByUid");
            Log.e("MY_TEST", "urlBuilder");
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=de8Q96jmb%2FJj%2BopbZdsPv5k4%2F2XDiyfTluNAwrhznOJROomUFPdf7D4M%2Bzw%2BbXjCIY%2B1VqXP%2BTmJaY7wOShFIA%3D%3D");
            urlBuilder.append("&" + URLEncoder.encode("arsId", "UTF-8") + "=" + URLEncoder.encode("48066", "UTF-8"));

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            BufferedReader rd;

            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            Log.e("Station_Name_TEST_ARSID", sb.toString());
            rd.close();
            conn.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
