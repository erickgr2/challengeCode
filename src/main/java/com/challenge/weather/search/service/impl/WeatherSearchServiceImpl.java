package com.challenge.weather.search.service.impl;

import com.challenge.weather.search.client.OpenWeatherClient;
import com.challenge.weather.search.formatter.OpenWeatherFormatter;
import com.challenge.weather.search.service.WeatherSearchService;
import com.challenge.weather.search.view.CityWeather;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Implementation for WeatherSearchService interface.
 * 
 * @author garad
 *
 */
@Service
public class WeatherSearchServiceImpl implements WeatherSearchService {


  /**
   * OpenWeatherClient dependency to make the call to OpenWeather API.
   */
  @Autowired
  OpenWeatherClient openWeatherClient;

  /**
   * Method that searches weather information by city name.
 * @throws UnsupportedEncodingException 
   */
  @Override
  public CityWeather getWeatherInfo(String city) throws UnsupportedEncodingException {

    return OpenWeatherFormatter.convertToCityWeather(openWeatherClient.getWeather(city));
  }

}
