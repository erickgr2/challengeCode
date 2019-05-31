package com.challenge.weather.search.util;

import com.challenge.weather.search.client.model.CurrentWeather;
import com.challenge.weather.search.client.model.MainInfo;
import com.challenge.weather.search.client.model.Sys;
import com.challenge.weather.search.client.model.Weather;
import com.challenge.weather.search.constants.Constants;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.TimeZone;

/**
 * Utility class for common or reusable methods.
 * 
 * @author Erick Garcia
 *
 */
public class Utility {

  private Utility() {

  }

  /**
   * Method to convert from Kelvin to Fahrenheit degrees.
   * 
   * @param temp of type Double
   * @return Double type reference.
   */
  public static Double convertKelvinToFahr(Double temp) {
    return Math.floor((((temp - 273.15) * 9 / 5) + 32) * 100) / 100;
  }

  /**
   * Method to convert from Kelvin to Celsius degrees.
   * 
   * @param temp of type Double
   * @return Double type reference.
   */
  public static Double convertKelvinToCelsius(Double temp) {
    return Math.floor((temp - 273.15) * 100) / 100;
  }

  /**
   * Method to convert a time in Long format to a LocalTime in String format.
   * 
   * @param time of type Long
   * @param zoneId of type Long
   * @return String reference.
   */
  public static String convertTimeStampToLocalTime(Long time, Long zoneId) {
    String pattern = Constants.TIME12HFORMAT;
    LocalDateTime ldt = getDateTimeFromTimestamp(time, zoneId);
    LocalTime lt = ldt.toLocalTime();
    return lt.format(DateTimeFormatter.ofPattern(pattern));

  }

  /**
   * Method to obtain convert a timestamp in long to a LocalDateTime reference.
   * 
   * @param timestamp of type Long
   * @param zoneId of type Long
   * @return LocalDateTime reference.
   */
  public static LocalDateTime getDateTimeFromTimestamp(Long timestamp, Long zoneId) {
    return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp + zoneId),
        TimeZone.getTimeZone(Constants.TIMEZONE).toZoneId());
  }
  
  /**
   * Method that validates the current status of description field in Weather reference.
   * @param cw of type CurrentWeather
   * @return boolean value.
   */
  public static boolean validateDescription (CurrentWeather cw) {
    Optional<CurrentWeather> cwo = Optional.ofNullable(cw);
    if (cwo.filter(p -> !p.getWeather().isEmpty()).isPresent()) {
      Optional<Weather> weat = Optional.of(cwo.get().getWeather().get(0));
      return weat.get().getDescription() != null;
    }
    return false;    
  }
  
  public static boolean validateTemp (CurrentWeather cw) {
    Optional<MainInfo> cwo = Optional.ofNullable(cw.getMain());
    return cwo.isPresent() ? cwo.get().getTemp() != null : Boolean.valueOf(false);
   
  }
  
  public static boolean validateSunset (CurrentWeather cw) {
    Optional<Sys> sysInf = getSysInf(cw);
    return sysInf.isPresent() ? sysInf.get().getSunset() != null : Boolean.valueOf(false);
  }
  
  public static boolean validateSunrise (CurrentWeather cw) {
    Optional<Sys> sysInf = getSysInf(cw);
    return sysInf.isPresent() ? sysInf.get().getSunrise() != null : Boolean.valueOf(false);
  }
  
  public static Optional<Sys> getSysInf(CurrentWeather cw){
    return Optional.ofNullable(cw.getSys());
  }
}


