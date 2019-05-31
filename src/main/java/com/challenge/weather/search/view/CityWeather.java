package com.challenge.weather.search.view;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;



/**
 * POJO class used to show information in the static content.
 * 
 * @author Erick Garcia
 *
 */
@Getter
@Setter
public class CityWeather {

  LocalDate date;
  String city;
  String description;
  String temperatureC;
  String temperatureF;
  String sunriseTime;
  String sunsetTime;


}
