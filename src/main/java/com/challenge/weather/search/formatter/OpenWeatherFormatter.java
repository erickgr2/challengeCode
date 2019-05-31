package com.challenge.weather.search.formatter;

import com.challenge.weather.search.client.model.CurrentWeather;
import com.challenge.weather.search.constants.Constants;
import com.challenge.weather.search.util.Utility;
import com.challenge.weather.search.view.CityWeather;

import java.time.LocalDate;

/**
 * Formatter class.
 * 
 * @author Erick Garcia
 *
 */
public class OpenWeatherFormatter {

  private OpenWeatherFormatter() {}

  /**
   * Method to convert from CurrentWeather to CityWeather type.
   * 
   * @param currentWeather object.
   * @return CityWeather object.
   */
  public static CityWeather convertToCityWeather(CurrentWeather currentWeather) {


    CityWeather cw = new CityWeather();
    cw.setCity(currentWeather.getName());
    LocalDate date = LocalDate.now();
    cw.setDate(date);
    cw.setDescription(Utility.validateDescription(currentWeather)?currentWeather
        .getWeather().get(0).getDescription() : Constants.EMPTY);
    cw.setTemperatureF(Utility.validateTemp(currentWeather) ? Utility
        .convertKelvinToFahr(currentWeather.getMain().getTemp()).toString() : Constants.EMPTY);
    cw.setTemperatureC(Utility.validateTemp(currentWeather) ? Utility
        .convertKelvinToCelsius(currentWeather.getMain().getTemp()).toString() : Constants.EMPTY);
    cw.setSunriseTime(Utility.validateSunrise(currentWeather) ? Utility
        .convertTimeStampToLocalTime(currentWeather.getSys().getSunrise(),
        currentWeather.getTimezone()) : Constants.EMPTY);
    cw.setSunsetTime(Utility.validateSunset(currentWeather) ? Utility
        .convertTimeStampToLocalTime(currentWeather.getSys().getSunset(),
        currentWeather.getTimezone()) : Constants.EMPTY);
    return cw;

  }

}
