package org.example;

//This class represents a data object for weather info
public class WeatherData {

    private String date;
    private double avgTemp;
    private double precipitation;
    private int humidity;
    private int windSpeed;

    //Constructor - lets you set values for when the object is created
    public WeatherData(String date, double avgTemp, double precipitation, int humidity, int windSpeed) {
        this.date =date;
        this.avgTemp = avgTemp;
        this.precipitation = precipitation;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    //Constructor to parse values from strings -- used in Reader to convert string values to right data type and store correctly
    public WeatherData(String date, String avgTemp, String precipitation, String humidity, String windSpeed) {
        // Parse date
        this.date = date;

        // Parse average temperature
        try {
            this.avgTemp = Double.parseDouble(avgTemp);
        } catch (NumberFormatException e) {
            this.avgTemp = 0; // Set a default value or handle the missing/incorrect data case
        }

        // Parse precipitation
        try {
            this.precipitation = Double.parseDouble(precipitation);
        } catch (NumberFormatException e) {
            this.precipitation = 0; // Set a default value or handle the missing/incorrect data case
        }

        // Parse humidity
        try {
            this.humidity = Integer.parseInt(humidity);
        } catch (NumberFormatException e) {
            this.humidity = 0; // Set a default value or handle the missing/incorrect data case
        }

        // Parse wind speed
        try {
            this.windSpeed = Integer.parseInt(windSpeed);
        } catch (NumberFormatException e) {
            this.windSpeed = 0; // Set a default value or handle the missing/incorrect data case
        }
    }

    //Getters and Setters - methods that enable you to retrieve values
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }
}
