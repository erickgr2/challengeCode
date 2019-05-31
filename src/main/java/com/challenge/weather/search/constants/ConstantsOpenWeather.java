package com.challenge.weather.search.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;


@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties("openweather")
@Data
public class ConstantsOpenWeather {
	
	@Value("openweather.uri")
	public String uri;
	
	@Value("openweather.appId")
	public String appId;
	

}
