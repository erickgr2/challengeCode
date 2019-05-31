package com.challenge.weather.search.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CityValidator implements ConstraintValidator<CityConstraint, String> {


  @Override
  public boolean isValid(String city, ConstraintValidatorContext context) {
    return city != null && (city.equalsIgnoreCase("London") || city.equalsIgnoreCase("Hong Kong"));
  }

}
