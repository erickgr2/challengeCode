package com.challenge.weather.search.client.model;

import lombok.Data;

@Data
public class Sys {

  private int type;
  private int id;
  private Double message;
  private String country;
  private Long sunrise;
  private Long sunset;
}
