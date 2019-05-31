package com.challenge.weather.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Main class to launch the application.
 * 
 * @author Erick Garcia
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
public class WeatherSearchApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeatherSearchApplication.class, args);
  }

}
