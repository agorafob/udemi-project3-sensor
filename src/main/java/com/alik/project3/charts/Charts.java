package com.alik.project3.charts;

import com.alik.project3.models.Measurement;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class Charts {

    public static void createChart(List<Measurement> list){
        List<Integer> time = new ArrayList<>();
        List<Double> temperature = new ArrayList<>();
        int counter = 1;
        for (Measurement m:list) {
            time.add(counter++);
            temperature.add(m.getValue());
        }
        XYChart chart = QuickChart.getChart("Weather Chart","Time", "Temperature",
                "Time/Temperature chart",time,temperature);
        new SwingWrapper<>(chart).displayChart();
    }
}
