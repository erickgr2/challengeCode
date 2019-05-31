package com.challenge.weather.search.client;

import java.io.UnsupportedEncodingException;

import com.challenge.weather.search.client.model.CurrentWeather;

/**
 * Interface that contains the method signatures to consume OpenWeather API.
 * 
 * @author Erick Garcia
 *
 */
public interface OpenWeatherClient {


  CurrentWeather getWeather(String city) throws UnsupportedEncodingException;

}
