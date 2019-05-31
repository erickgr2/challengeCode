package com.challenge.weather.search.client.model;

import lombok.Data;

import java.util.List;


@Data
public class CurrentWeather {

  private List<Weather> weather;

  private String base;

  private MainInfo main;

  private Double visibility;

  private Sys sys;

  private String name;

  private Long timezone;

}
