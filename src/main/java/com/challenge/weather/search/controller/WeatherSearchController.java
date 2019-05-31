package com.challenge.weather.search.controller;

import java.io.UnsupportedEncodingException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

import com.challenge.weather.search.constants.Constants;
import com.challenge.weather.search.constants.ConstantsGeneral;
import com.challenge.weather.search.service.WeatherSearchService;
import com.challenge.weather.search.view.City;
import com.challenge.weather.search.view.CityWeather;

/**
 * WeatherSearchController to manage the request from the static content.
 * 
 * @author Erick Garcia
 *
 */
@Controller
public class WeatherSearchController {
	
  private static final Logger log = LoggerFactory.getLogger(WeatherSearchController.class);

  /**
   * Injected dependency to search the weather information.
   */
  @Autowired
  WeatherSearchService weatherSearchService;
  
  @Autowired
  ConstantsGeneral constantsGeneral;

  /**
   * entry point to display the initial page.
   * 
   * @return ModwlAndView object.
   */
  @GetMapping("weather")
  public ModelAndView showForm() {
    return cleanView();
  }



  /**
   * Entry point launched when a weather search by city name is performed.
   * 
   * @param city of type City.
   * @param result of type BindingResult.
   * @param model of type ModelMap.
   * @return ModelAndView objet with the information requested.
   */
  @PostMapping("weather")
  public String submit(@Valid @ModelAttribute("city") City city, BindingResult result,
      ModelMap model) {
	
	CityWeather cw = new CityWeather();
	
    if (result.hasErrors()) {
      model.addAttribute(Constants.CITYWEATHERLABEL, cw);
      return Constants.INITIAL_PAGE;
    }
    String view  = Constants.INITIAL_PAGE;
	try {
		cw = weatherSearchService.getWeatherInfo(city.getName());
	}  catch (HttpClientErrorException ex) {
		view = decideView(ex.getRawStatusCode());
		String message = ex.getMessage();
		log.error(message);
	}  catch (UnsupportedEncodingException ex) {
		String message = ex.getMessage();
		log.error(message);
		view = constantsGeneral.getServerError();
	}
    model.addAttribute(Constants.CITYWEATHERLABEL, cw);
    return view;
  }
  
 /**
  * Method to create a clean model and view.
  * @return ModelAndView reference.
  */
  private ModelAndView cleanView() {
	ModelAndView mv = new ModelAndView();
	mv.addObject("city", new City());
	mv.addObject("cityWeather", new CityWeather());
	mv.setViewName(Constants.INITIAL_PAGE);
	return mv;
  }
  
  
  private String decideView(int status){
	  String view;
	  switch(status) {
	  case 400: view = constantsGeneral.getError(); log.info(view);break;
	  case 401: view = constantsGeneral.getUnauthorized();log.info(view); break;
	  case 500: view = constantsGeneral.getServerError();log.info(view); break;
	  default: view = Constants.INITIAL_PAGE; log.info(view); break;
	  }
	  
	  return view;
  }
}
