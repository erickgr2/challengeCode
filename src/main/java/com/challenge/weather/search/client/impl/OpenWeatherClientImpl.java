package com.challenge.weather.search.client.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.challenge.weather.search.client.OpenWeatherClient;
import com.challenge.weather.search.client.model.CurrentWeather;
import com.challenge.weather.search.constants.Constants;
import com.challenge.weather.search.constants.ConstantsOpenWeather;


/**
 * Class that implements OpenWeatherClient interface.
 * 
 * @author Erick
 *
 */
@Service
public class OpenWeatherClientImpl implements OpenWeatherClient {


  private static final Logger log = LoggerFactory.getLogger(OpenWeatherClientImpl.class);

  /**
   * RestTemplate attribute to perform calls to OpenWeatherAPI.
   */
  RestTemplate restTemplate;

  @Autowired
  ConstantsOpenWeather constantsConfig;


  /**
   * Method that performs the call to OpenWeatherAPI.
 * @throws UnsupportedEncodingException 
   */
  @Override
  public CurrentWeather getWeather(String city) throws UnsupportedEncodingException {
	 
    restTemplate = new RestTemplate();
    URI expanded = new UriTemplate(constantsConfig.getUri())
    		.expand(city, constantsConfig.getAppId());
    
      String url = URLDecoder.decode(expanded.toString(), Constants.UTF8EN);
      ResponseEntity<CurrentWeather> cw = restTemplate.getForEntity(url, CurrentWeather.class);
      Optional<CurrentWeather> currentWeather = Optional.ofNullable(cw.getBody());
      CurrentWeather result = currentWeather.orElse(new CurrentWeather());
      String msg = "OpenWeather result: " + result;
      log.info(msg);
      return result;
      
  }

}
