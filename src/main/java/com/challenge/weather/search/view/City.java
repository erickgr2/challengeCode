package com.challenge.weather.search.view;

import com.challenge.weather.search.validator.CityConstraint;

import lombok.Data;

/**
 * POJO model for City.
 * 
 * @author Erick Garcia
 *
 */
@Data
public class City {

  @CityConstraint
  private String name;

}
