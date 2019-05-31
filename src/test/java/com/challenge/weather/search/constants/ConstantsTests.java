package com.challenge.weather.search.constants;

/**
 * Class that contains the constants needed in the tests.
 * @author Erick Garcia
 *
 */
public class ConstantsTests {

  public static final String CITY = "LONDON";
  public static final String INITIAL_VIEW = "weather";
  public static final String BAD_VIEW = "error";
  public static final String UNAUT_VIEW = "unAuthorized";
  public static final String SERVER_ERROR = "serverError";
  public static final String BASE_PATH = "/weather";
  public static final String EMPTY = "";
  public static final String URI = 
		  "https://api.openweathermap.org/data/2.5/weather?q={city}&APPID={appId}";
  public static final String APPID = "6439103f2055efe2d2159bd06c670f5b";

  
  private ConstantsTests() {

  }



}
