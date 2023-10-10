package com.alik.project3;

import com.alik.project3.charts.Charts;
import com.alik.project3.get.GetMeasurements;
import com.alik.project3.models.Sensor;
import com.alik.project3.post.AddMeasurements;
import com.alik.project3.post.CreateSensor;
import com.alik.project3.url.Urls;
import org.springframework.web.client.RestTemplate;

public class App
{
    public static void main( String[] args )
    {
        RestTemplate restTemplate = new RestTemplate();
        Sensor firstSensor = new Sensor("First Sensor");
        CreateSensor.create(firstSensor,restTemplate, Urls.SENSOR_REGISTRATION_URL);
        AddMeasurements.postOneMeasurement(firstSensor,restTemplate,Urls.MEASUREMENTS_ADD_URL);
        AddMeasurements.post1000Measurements(firstSensor,restTemplate,Urls.MEASUREMENTS_ADD_URL);
        GetMeasurements.getAllMeasurements(restTemplate,Urls.MEASUREMENTS_GET_URL);
        GetMeasurements.getRainyDaysCount(firstSensor,restTemplate,Urls.RAINY_DAYS_COUNT_URL);
        Charts.createChart(GetMeasurements.getMeasurementsForChart(restTemplate,Urls.MEASUREMENTS_GET_URL));
    }
}
