package com.challenge.weather.search.client.util;

import static org.junit.Assert.assertEquals;
import com.challenge.weather.search.client.model.CurrentWeather;
import com.challenge.weather.search.client.model.MainInfo;
import com.challenge.weather.search.client.model.Sys;
import com.challenge.weather.search.client.model.Weather;
import com.challenge.weather.search.util.Utility;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that perfoms the tests upon the Utility class
 * @author garad
 *
 */
@RunWith(SpringRunner.class)
public class UtilityTest {
  
  CurrentWeather cw;
  
  Double testTemp;
  
  @Before
  public void init() {
    testTemp = new Double(273.15);
    cw = new CurrentWeather();
    List<Weather> weather = new ArrayList<>();
    Weather we = new Weather();
    we.setDescription("rainny");
    weather.add(we);
    cw.setWeather(weather);
    MainInfo main = new MainInfo();
    main.setTemp(283.2);
    cw.setMain(main);
    Sys sys = new Sys();
    sys.setSunrise(12342421l);
    sys.setSunset(12342421l);
    cw.setSys(sys);
    
  }
  
  @Test
  public void validateDescriptionTest() {
    assertEquals(true,Utility.validateDescription(cw));
  }
  
  @Test
  public void validateMainInfoTest() {
    assertEquals(true,Utility.validateTemp(cw));
  }
  
  @Test
  public void validateSunsetTest() {
    assertEquals(true,Utility.validateSunset(cw));
  }
  
  @Test
  public void validateSunriseTest() {
    assertEquals(true,Utility.validateSunrise(cw));
  }
  
  @Test
  public void validateTempCelsius() {
    
    assertEquals(Double.valueOf(0),Utility.convertKelvinToCelsius(testTemp));
  }
  
  
  @Test
  public void validateTempFahrenheit() {
    
    assertEquals(Double.valueOf(32),Utility.convertKelvinToFahr(testTemp));
  }
}
