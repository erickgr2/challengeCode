package com.challenge.weather.search.service;

import java.io.UnsupportedEncodingException;

import com.challenge.weather.search.view.CityWeather;

/**
 * WeatherSearchService.
 * 
 * @author Erick
 *
 */
public interface WeatherSearchService {

  CityWeather getWeatherInfo(String city) throws UnsupportedEncodingException;

}
