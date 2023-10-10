package com.alik.project3.post;

import com.alik.project3.models.Sensor;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

public class CreateSensor {
    public static void create(Sensor sensor,RestTemplate restTemplate, String url) {
        System.out.println("Sensor created/posted " + restTemplate.postForObject(url, sensor, HttpStatus.class));

    }
}
