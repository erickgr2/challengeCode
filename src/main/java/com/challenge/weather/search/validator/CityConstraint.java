package com.challenge.weather.search.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Customized annotation to validate city name.
 * 
 * @author Erick Garcia
 *
 */
@Documented
@Constraint(validatedBy = CityValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CityConstraint {
  
  /**
   * Default method that retrieves the error message.
   * @return String reference.
   */
  String message() default "*Invalid city";

  /**
   * Default method for groups.
   * @return Class object.
   */
  Class<?>[] groups() default {};

  /**
   * Default method for payload.
   * @return Class object.
   */
  Class<? extends Payload>[] payload() default {};

}

