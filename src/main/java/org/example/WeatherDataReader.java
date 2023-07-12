package org.example;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataReader {

    public List<WeatherData> parseCSVFile(String filePath) {
        List<WeatherData> weatherDataList = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            boolean isFirstLine = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");

                String date = data[0];

                String avgTempStr = data[1];
                double avgTemp;
                if (!avgTempStr.isEmpty() && !avgTempStr.equals("Not Available")) { //if it's not empty & not N/A it will parse the data
                    avgTemp = Double.parseDouble(avgTempStr);
                } else {
                    avgTemp= Double.NaN;//this is for missing data
//                    avgTemp = 0.0; // default value
                }

                String precipitationStr = data[2];
                double precipitation;
                if (!precipitationStr.isEmpty() && !precipitationStr.equals("Not Available")) { // checks to see if it is empty or equal to 'N/A'
                    precipitation = Double.parseDouble(precipitationStr);
                } else {
                    precipitation= Double.NaN;//this is for missing data
//                    precipitation = 0.0; // default value
                }

                String humidityStr = data[3];
                int humidity;
                if (!humidityStr.isEmpty()) {
                    humidity = Integer.parseInt(humidityStr);
                } else {
                    humidity = 0; // default value
                }

                int windSpeed = Integer.parseInt(data[4]);

                //Object that stores weather data info
                WeatherData weatherData = new WeatherData(date, avgTemp, precipitation, humidity, windSpeed);
                weatherDataList.add(weatherData);
            }

        } catch (IOException e) {
            e.printStackTrace(); // Handles exception
        }

        return weatherDataList;
    }
}
