package com.challenge.weather.search.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;


@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties("constants.view")
@Data
public class ConstantsGeneral {
	
	
	@Value("constants.view.error")
    public String error;	
		
	@Value("constants.view.unauthorized")
	public String unauthorized;
	
	@Value("constants.view.serverError")
	public String serverError;

}
