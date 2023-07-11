package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class WeatherAnalyzerTest {

    @Test
    void averageTempCalculations() {
        //Testing data
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData("2023-07-11", 20.0, 0.0, 50, 10));
        weatherDataList.add(new WeatherData("2023-01-02", 25.0, 0.0, 55, 12));
        weatherDataList.add(new WeatherData("2023-01-03", 30.0, 0.0, 60, 15));
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(weatherDataList);

        //Executes method
        double avgTemp = weatherAnalyzer.averageTempCalc();

        //Shows results
        assertEquals(25.0, avgTemp, 0.01);
    }


    @Test
    void testFindHeatwaves() {
        //Testing data
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData("2023-01-01", 20.0, 0.0, 50, 10));
        weatherDataList.add(new WeatherData("2023-01-02", 25.0, 0.0, 55, 12));
        weatherDataList.add(new WeatherData("2023-01-03", 30.0, 0.0, 60, 15));
        weatherDataList.add(new WeatherData("2023-01-04", 28.0, 0.0, 58, 11));
        weatherDataList.add(new WeatherData("2023-01-05", 32.0, 0.0, 62, 13));
        weatherDataList.add(new WeatherData("2023-01-06", 33.0, 0.0, 64, 16));
        weatherDataList.add(new WeatherData("2023-01-07", 27.0, 0.0, 57, 10));
        weatherDataList.add(new WeatherData("2023-01-08", 35.0, 0.0, 68, 17));
        weatherDataList.add(new WeatherData("2023-01-09", 31.0, 0.0, 61, 14));
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(weatherDataList);

        // Execute the method
        List<String> heatwavePeriods = weatherAnalyzer.findHeatwaves(3, 30.0);

        // Verify the result
        List<String> expectedPeriods = new ArrayList<>();
        expectedPeriods.add("2023-01-03 to 2023-01-05");
        expectedPeriods.add("2023-01-06 to 2023-01-08");
        assertEquals(expectedPeriods, heatwavePeriods);
    }

}