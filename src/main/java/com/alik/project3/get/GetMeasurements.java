package com.alik.project3.get;

import com.alik.project3.models.Measurement;
import com.alik.project3.models.Sensor;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


public class GetMeasurements {

    public static void getAllMeasurements(RestTemplate restTemplate, String url) {
        Measurement[] list = restTemplate.getForObject(url, Measurement[].class);
        assert list != null;
        for (Measurement m : list) {
            System.out.println(m);
        }
    }

    public static List<Measurement> getMeasurementsForChart(RestTemplate restTemplate, String url) {
        Measurement[] list = restTemplate.getForObject(url, Measurement[].class);
        assert list != null;
        return Arrays.asList(list);
    }


    public static void getRainyDaysCount(Sensor sensor, RestTemplate restTemplate, String url) {
        String append = "?name=" + sensor.getName();
        String finalUrl = url + append;
        System.out.println(restTemplate.getForObject(finalUrl, String.class));
    }
}
