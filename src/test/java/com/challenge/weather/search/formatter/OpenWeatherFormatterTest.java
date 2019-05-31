package com.challenge.weather.search.formatter;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.weather.search.client.model.CurrentWeather;
import com.challenge.weather.search.client.model.MainInfo;
import com.challenge.weather.search.client.model.Sys;
import com.challenge.weather.search.client.model.Weather;
import com.challenge.weather.search.view.CityWeather;

@RunWith(SpringRunner.class)
public class OpenWeatherFormatterTest {
	
	
	CurrentWeather currentWeather;
	
	
	
	@Before
	public void init() {
		
	    currentWeather = new CurrentWeather();
	    List<Weather> weather = new ArrayList<>();
	    Weather e = new Weather();
	    String description = "";
	    e.setDescription(description);
	    weather.add(e);
	    currentWeather.setWeather(weather);
	    MainInfo main = new MainInfo();
	    Double temp = Double.valueOf(273.15);
	    main.setTemp(temp);
	    currentWeather.setMain(main);
	    Sys sys = new Sys();
	    sys.setSunrise(Long.valueOf(1558954865));
	    sys.setSunset(Long.valueOf(1558954865));
	    currentWeather.setSys(sys);
	    currentWeather.setTimezone(Long.valueOf(28800));
	    currentWeather.setName("London");
		
	}
	
	@Test
	public void convertToCityWeatherTest() {
		
		CityWeather citiW = OpenWeatherFormatter.convertToCityWeather(currentWeather);
		assertNotNull(citiW.getCity());
		assertNotNull(citiW.getDescription());
		assertNotNull(citiW.getDate());
		assertNotNull(citiW.getSunriseTime());
		assertNotNull(citiW.getSunriseTime());
		assertNotNull(citiW.getSunsetTime());
		assertNotNull(citiW.getTemperatureC());
		assertNotNull(citiW.getTemperatureF());
		
		
		
	}

}
