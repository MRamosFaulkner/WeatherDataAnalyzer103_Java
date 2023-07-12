package org.example;

import java.text.DecimalFormat;
import java.util.List;
import java.text.DateFormat;

public class WeatherDataAnalyzer {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\admin\\Documents\\CTAC\\Assignments\\FullStack103\\WeatherDataAnalyzer-Java\\JavaWeatherDataAnalyzerProject\\src\\main\\java\\org\\example\\data.csv";

        System.out.println("\033[1;94m\nWelcome to the Weather Data Analyzer\u001B[0m\n");

        //Instantiating new instances of respective classes
        WeatherDataReader weatherDataReader = new WeatherDataReader();
        List<WeatherData> weatherDataList = weatherDataReader.parseCSVFile(filePath);//Returns list created from reader

        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(weatherDataList);//Analyzes data from weather data list

        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        //AVG TEMP
        System.out.println("\033[0;34mAverage Temperature Info: \u001B[0m");
        double averageTemperature = weatherAnalyzer.averageTempCalc();
        System.out.println("Average Temperature: " + decimalFormat.format(averageTemperature) + " F");

        WeatherData lowestTemperatureData = weatherAnalyzer.getDayWithLowestTemperature();
        System.out.println("Lowest Temperature: " + lowestTemperatureData.getAvgTemp() + " F (" + lowestTemperatureData.getDate() + ")");

        WeatherData highestTemperatureData = weatherAnalyzer.getDayWithHighestTemperature();
        System.out.println("Highest Temperature: " + highestTemperatureData.getAvgTemp() + " F (" + highestTemperatureData.getDate() + ")\n");

        //PRECIPITATION
        System.out.println("\033[0;34mPrecipitation Info: \u001B[0m");
        double averagePrecipitation = weatherAnalyzer.averagePrecipitationCalc();
        System.out.println("Average Precipitation: " + decimalFormat.format(averagePrecipitation) + " inches");

        WeatherData lowestPrecipitationData = weatherAnalyzer.getDayWithLowestPrecipitation();
        System.out.println("Lowest Precipitation: " + lowestPrecipitationData.getPrecipitation() + " inches (multiple days)");

        WeatherData highestPrecipitationData = weatherAnalyzer.getDayWithHighestPrecipitation();
        System.out.println("Highest Precipitation: " + highestPrecipitationData.getPrecipitation() + " inches (" + highestPrecipitationData.getDate() + ")\n");

        //HUMIDITY
        System.out.println("\033[0;34mHumidity Info: \u001B[0m");
        Double averageHumidity = weatherAnalyzer.averageHumidityCalc();
        System.out.println("Average Humidity: " + decimalFormat.format(averageHumidity) + " %");

        WeatherData lowestHumidityData = weatherAnalyzer.getDayWithLowestHumidity();
        System.out.println("Lowest Humidity: " + lowestHumidityData.getHumidity() + " % (multiple days)");

        WeatherData highestHumidityData = weatherAnalyzer.getDayWithHighestHumidity();
        System.out.println("Highest Humidity: " + highestHumidityData.getHumidity() + " % (" + highestHumidityData.getDate() + ")\n");

        //WIND SPEED
        System.out.println("\033[0;34mWind Speed Info: \u001B[0m");
        Double averageWindSpeed = weatherAnalyzer.averageWindSpeedCalc();
        System.out.println("Average Wind Speed: " + decimalFormat.format(averageWindSpeed) + " mph");

        WeatherData lowestWindSpeedData = weatherAnalyzer.getDayWithLowestWindSpeed();
        System.out.println("Lowest Wind Speed: " + lowestWindSpeedData.getWindSpeed() + " mph (" + lowestWindSpeedData.getDate() + ")");

        WeatherData highestWindSpeedData = weatherAnalyzer.getDayWithHighestWindSpeed();
        System.out.println("Highest Wind Speed: " + highestWindSpeedData.getWindSpeed() + " mph (" + highestWindSpeedData.getDate() + ")\n");

        System.out.println("\033[0;34mTrends or Patterns\u001B[0m");

        String comparisonResult = weatherAnalyzer.compareAverageTemperature("05", "06");//5 & 6 are month values being passed and assigns the results to 'comparisonResult' to be printed
        System.out.println(comparisonResult);

        List<String> heatwavePeriods = weatherAnalyzer.findHeatwaves(3, 80.0);
        System.out.println("\033[0;34mHeatwave Periods:\u001B[0m");
        for (String period : heatwavePeriods) {
            System.out.println(period);
        }

        //Missing or incorrect data
        weatherAnalyzer.handlesMissingData();

    }
}
