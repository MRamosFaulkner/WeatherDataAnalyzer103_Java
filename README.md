# Weather Data Analyzer
The Weather Data Analyzer is a Java program that analyzes a dataset of weather conditions over a certain period. and provides various statistical calculations and findings. It processes a list of weather data entries and performs calculations such as average temperature, highest and lowest temperatures, average precipitation, average humidity, average wind speed, comparison of average temperatures between two months, and identification of heatwave periods.

## Running the Program

Ensure you have JDK installed, and correct repo.
Compile and run the WeatherDataAnalyzer ('main') class

### Challenges

Some of the methods were a little challenging to handle because the data had missing information. The program needed to output correct data while also being able to handle missing or incomplete data entries. To address this, a `handlesMissingData` method was implemented to identify and exclude entries with missing or incorrect data from the analysis.

Also, comparing average temperatures between two months required extracting and calculating data for each month separately. This was accomplished by iterating over the weather entries, identifying the month of each entry, and calculating the averages for the respective months.


