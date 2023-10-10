package com.alik.project3.post;

import com.alik.project3.models.Measurement;
import com.alik.project3.models.Sensor;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import java.util.Random;

public class AddMeasurements {

    public static void postOneMeasurement(Sensor sensor,RestTemplate restTemplate,String url){
        Random random = new Random();
        double value = (double) Math.round((random.nextDouble() * 200 - 100) * 100) /100;
        boolean rain = getRain(value);
        Measurement measurement = new Measurement(value,rain,sensor);
        restTemplate.postForObject(url, measurement, HttpStatus.class);
    }

    public static void post1000Measurements(Sensor sensor,RestTemplate restTemplate,String url){
        for (int i = 0; i < 1000; i++) {
            postOneMeasurement(sensor,restTemplate,url);
        }
    }

    private static boolean getRain(double value){
        return value>0.00 && value <20.00;
    }
}
