package org.example;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WeatherAnalyzer {

    private List<WeatherData> weatherDataList;

    public WeatherAnalyzer(List<WeatherData> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    //*** AVG TEMP METHODS
    public double averageTempCalc() {
        double sum = 0;
        int count = 0;
        for (WeatherData weatherData : weatherDataList) {
           double avgTemp =weatherData.getAvgTemp();
            if (!Double.isNaN(avgTemp) && avgTemp != 0) {
                sum += avgTemp;
                count++;
            }
        }
        return count > 0 ? sum / count : 0.0;
    }

//    public WeatherData getDayWithLowestTemperature() {
//        WeatherData lowestTemperatureData = weatherDataList.get(0);
//        for (WeatherData weatherData : weatherDataList) {
//            if (weatherData.getAvgTemp() < lowestTemperatureData.getAvgTemp()) {
//                lowestTemperatureData = weatherData;
//            }
//        }
//        return lowestTemperatureData;
//    }

    public WeatherData getDayWithLowestTemperature() {
        WeatherData lowestTemperatureData = null;//This initializes lowest temp as null

        for (WeatherData weatherData : weatherDataList) {
            double avgTemp = weatherData.getAvgTemp();

            /**
             * Makes sure to return a temp instead of zero, by bypassing empty values
             * Compares avg temp to the lowest temp
             */
            if (avgTemp != 0 && (lowestTemperatureData == null || avgTemp < lowestTemperatureData.getAvgTemp())) {
                lowestTemperatureData = weatherData;
            }
        }

        return lowestTemperatureData;
    }


    public WeatherData getDayWithHighestTemperature() {
        WeatherData highestTemperatureData = weatherDataList.get(0);
        for (WeatherData weatherData : weatherDataList) {
            if (weatherData.getAvgTemp() > highestTemperatureData.getAvgTemp()) {
                highestTemperatureData = weatherData;
            }
        }
        return highestTemperatureData;
    }

    //PRECIPITATION METHODS
    public double averagePrecipitationCalc() {
        double sum = 0;
        int count = 0;
        for (WeatherData weatherData : weatherDataList) {
            double precipitation = weatherData.getPrecipitation();
            if (!Double.isNaN(precipitation ) && precipitation != 0) {
                sum += precipitation;
                count++;
            }
        }
        return count > 0 ? sum / count : 0.0;
    }


    public WeatherData getDayWithLowestPrecipitation() {
        WeatherData lowestPrecipitationData = null;

        for (WeatherData weatherData : weatherDataList) {
            double precipitation = weatherData.getPrecipitation();

            /**
             * Makes sure to return a temp instead of zero, by bypassing empty values
             * Compares avg temp to the lowest temp
             */
            if (precipitation != 0 && (lowestPrecipitationData == null || precipitation < lowestPrecipitationData.getAvgTemp())) {
                lowestPrecipitationData = weatherData;
            }
        }

        return lowestPrecipitationData;
    }

    public WeatherData getDayWithHighestPrecipitation() {
        WeatherData highestPrecipitationData = null;

        for (WeatherData weatherData : weatherDataList) {
            double precipitation = weatherData.getPrecipitation();

            if (precipitation != 0 && (highestPrecipitationData == null || precipitation > highestPrecipitationData.getPrecipitation())) {
                highestPrecipitationData = weatherData;
            }
        }

        return highestPrecipitationData;
    }

    //HUMIDITY METHODS
    public double averageHumidityCalc() {
        double sum = 0;
        int count = 0;
        for (WeatherData weatherData : weatherDataList) {
            sum += weatherData.getHumidity();
            count++;
        }
        return count > 0 ? sum / count : 0.0;
    }

    public WeatherData getDayWithLowestHumidity() {
        WeatherData lowestHumidityData = weatherDataList.get(0);
        for (WeatherData weatherData : weatherDataList) {
            if (weatherData.getHumidity() < lowestHumidityData.getHumidity()) {
                lowestHumidityData = weatherData;
            }
        }
        return lowestHumidityData;
    }

    public WeatherData getDayWithHighestHumidity() {
        WeatherData highestHumidityData = null;

        for (WeatherData weatherData : weatherDataList) {
            double humidity = weatherData.getHumidity();

            if (humidity != 0 && (highestHumidityData == null || humidity > highestHumidityData.getHumidity())) {
                highestHumidityData = weatherData;
            }
        }

        return highestHumidityData;
    }

    //WIND SPEED METHODS
    public double averageWindSpeedCalc() {
        double sum = 0;
        int count = 0;
        for (WeatherData weatherData : weatherDataList) {
            sum += weatherData.getWindSpeed();
            count++;
        }
        return count > 0 ? sum / count : 0.0;
    }

    public WeatherData getDayWithLowestWindSpeed() {
        WeatherData lowestWindSpeedData = weatherDataList.get(0);
        for (WeatherData weatherData : weatherDataList) {
            if (weatherData.getWindSpeed() < lowestWindSpeedData.getWindSpeed()) {
                lowestWindSpeedData = weatherData;
            }
        }
        return lowestWindSpeedData;
    }

    public WeatherData getDayWithHighestWindSpeed() {
        WeatherData highestWindSpeedData= null;

        for (WeatherData weatherData : weatherDataList) {
            double windSpeed = weatherData.getWindSpeed();

            if (windSpeed != 0 && (highestWindSpeedData == null || windSpeed > highestWindSpeedData.getWindSpeed())) {
                highestWindSpeedData = weatherData;
            }
        }

        return highestWindSpeedData;
    }


    // Method compares the avg temp between two months
    public String compareAverageTemperature(String month1, String month2) {
        double sumMonth1 = 0;
        double sumMonth2 = 0;
        int countMonth1 = 0;
        int countMonth2 = 0;
        DateTimeFormatter dateTimeFormatter =DateTimeFormatter.ofPattern("MM-dd-yyy");

        for (WeatherData weatherData : weatherDataList) {
            String month = weatherData.getDate().substring(0, 2);

            if (month.equals(month1)) {
                if (!Double.isNaN(weatherData.getAvgTemp()) && weatherData.getAvgTemp() != 0) {
                    sumMonth1 += weatherData.getAvgTemp();
                    countMonth1++;
                }
            } else if (month.equals(month2)) {
                if (!Double.isNaN(weatherData.getAvgTemp()) && weatherData.getAvgTemp() != 0) {
                    sumMonth2 += weatherData.getAvgTemp();
                    countMonth2++;
                }
            }
        }

        if (countMonth1 == 0 || countMonth2 == 0) {
            return "\u001B[31mInsufficient data to compare the average temperature between the two months.\u001B[0m\n";
        }

        double averageMonth1 = sumMonth1 / countMonth1;
        double averageMonth2 = sumMonth2 / countMonth2;
        double temperatureDifference = averageMonth1 - averageMonth2;

        //For no decimals
        DecimalFormat decimalFormat = new DecimalFormat("#");


        if (temperatureDifference > 0) {
            return getMonthName(month1) + "'s average temperature was " + decimalFormat.format(temperatureDifference) + " degrees higher than " + getMonthName(month2) + "'s.\n";
        } else if (temperatureDifference < 0) {
            return getMonthName(month1) + "'s average temperature was " + decimalFormat.format(Math.abs(temperatureDifference)) + " degrees lower than " + getMonthName(month2) + "'s.\n";
        } else {
            return getMonthName(month1) + "'s average temperature was the same as " + getMonthName(month2) + "'s.\n";
        }
    }


    private String getMonthName(String month) {
        // Add a mapping from the month number to its name
        switch (month) {
            case "01":
                return "January";
            case "02":
                return "February";
            case "03":
                return "March";
            case "04":
                return "April";
            case "05":
                return "May";
            case "06":
                return "June";
            case "07":
                return "July";
            case "08":
                return "August";
            case "09":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";
            default:
                return "Invalid Month";
        }
    }



    // Method that finds periods of heatwave
    public List<String> findHeatwaves(int consecutiveDays, double temperatureThreshold) {
        List<String> heatwavePeriods = new ArrayList<>();
        int heatwaveCount = 0;
        StringBuilder heatwavePeriod = new StringBuilder();

        for (WeatherData weatherData : weatherDataList) {
            if (weatherData.getAvgTemp() > temperatureThreshold) {
                if (heatwaveCount == 0) {
                    heatwavePeriod.append(weatherData.getDate());
                }
                heatwaveCount++;
            } else {
                if (heatwaveCount >= consecutiveDays) {
                    heatwavePeriod.append(" to ").append(weatherData.getDate());
                    heatwavePeriods.add(heatwavePeriod.toString());
                }
                heatwaveCount = 0;
                heatwavePeriod = new StringBuilder();
            }
        }

        return heatwavePeriods;
    }

    //Method handles missing data-- iterates over list
    public void handlesMissingData() {
        List<String> missingData = new ArrayList<>();

        for (WeatherData weatherData : weatherDataList) {
            if (weatherData.getAvgTemp() == 0.0 || Double.isNaN(weatherData.getAvgTemp())) {
                missingData.add(weatherData.getDate() + ": Missing AvgTemp");
            }
            if (weatherData.getHumidity() == 0) {
                missingData.add(weatherData.getDate() + ": Missing Humidity");
            }
            if (Double.isNaN(weatherData.getPrecipitation())) {
                missingData.add(weatherData.getDate() + ": Missing Precipitation");
            }
            if (Double.isNaN(weatherData.getAvgTemp())) {
                missingData.add(weatherData.getDate() + ": AvgTemp value 'Not Available' could not be parsed to a number");
            }
        }

        if (!missingData.isEmpty()) {
            System.out.println("\n\033[0;31mMissing or incorrect data\033[0m and were excluded from the analysis:\033[0m");
            Set<String> uniqueMissingData = new LinkedHashSet<>(missingData); // Remove duplicates
            for (String data : missingData) {
                System.out.println(data);
            }
        }
    }
}
