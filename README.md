# Weather Data Analyzer
The Weather Data Analyzer is a Java program that analyzes a dataset of weather conditions over a certain period. and provides various statistical calculations and findings. It processes a list of weather data entries and performs calculations such as average temperature, highest and lowest temperatures, average precipitation, average humidity, average wind speed, comparison of average temperatures between two months, and identification of heatwave periods.

## Running the Program

Ensure you have JDK installed, and correct repo.
Compile and run the WeatherDataAnalyzer ('main') class

### Challenges

Some of the methods were a little challenging to handle because the data had missing information. The program needed to output correct data while also being able to handle missing or incomplete data entries. To address this, a `handlesMissingData` method was implemented to identify and exclude entries with missing or incorrect data from the analysis.

Also, comparing average temperatures between two months required extracting and calculating data for each month separately. This was accomplished by iterating over the weather entries, identifying the month of each entry, and calculating the averages for the respective months.

### Summary of Data

The output of the Weather Analyzer provides valuable insights and findings about the weather data. Here's a brief summary of the data analysis findings:

- Average Temperature: The program calculates the average temperature based on available data entries. This value represents the overall average temperature across the given dataset.

- Lowest and Highest Temperatures: The program identifies the day with the lowest and highest average temperatures. These values indicate the extremes in temperature recorded in the dataset.

- Average Precipitation: The program calculates the average precipitation based on available data entries. This value represents the overall average precipitation across the given dataset.

- Average Humidity: The program calculates the average humidity based on available data entries. This value represents the overall average humidity across the given dataset.

- Average Wind Speed: The program calculates the average wind speed based on available data entries. This value represents the overall average wind speed across the given dataset.

- Comparison of Average Temperatures: The program compares the average temperatures between two specified months and provides a comparison result indicating which month had a higher or lower average temperature.

- Identification of Heatwave Periods: The program identifies periods of heatwaves based on consecutive days of temperatures above a specified threshold. It returns the start and end dates of each heatwave period.


