package com.challenge.weather.search.client.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import com.challenge.weather.search.client.model.CurrentWeather;
import com.challenge.weather.search.client.model.MainInfo;
import com.challenge.weather.search.client.model.Sys;
import com.challenge.weather.search.client.model.Weather;
import com.challenge.weather.search.constants.ConstantsOpenWeather;
import com.challenge.weather.search.constants.ConstantsTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for testing the functionality of OpenWeatherClientImpl class.
 * @author Erick Garcia
 *
 */
@RunWith(SpringRunner.class)
public class OpenWeatherClientImplTest {

  
  @Mock
  ConstantsOpenWeather constantsConfig;

  @InjectMocks
  private OpenWeatherClientImpl empService = new OpenWeatherClientImpl();

  CurrentWeather currentWeather;

  @Before
  public void setUp() {

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
    sys.setSunrise(Long.valueOf(1547654865));
    sys.setSunset(Long.valueOf(1558954865));
    currentWeather.setSys(sys);
    currentWeather.setTimezone(Long.valueOf(28800));
    currentWeather.setName("London");

  }

  @Test
  public void testRestCall() throws UnsupportedEncodingException {

	Mockito.when(constantsConfig.getUri()).thenReturn(ConstantsTests.URI);
	Mockito.when(constantsConfig.getAppId()).thenReturn(ConstantsTests.APPID);
    String city = "London";
    CurrentWeather cw = empService.getWeather(city);
    
    assertNotNull(cw);
    assertNotNull(cw.getSys().getSunrise());
    assertNotNull(cw.getSys().getSunset());
    assertNotNull(cw.getTimezone());
    assertNotNull(cw.getWeather().get(0).getDescription());
    assertNotNull(cw.getMain().getTemp());
    assertArrayEquals(new String[] {"London"}, new String[] {cw.getName()});



  }

}
