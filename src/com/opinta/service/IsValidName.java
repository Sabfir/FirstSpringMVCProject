package com.opinta.service;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidName {
	String listOfNames() default "";
	String message() default "Please provide a valid Name; " +
			"accepted names are - Oleg, Oleh, Sabfir, Sab, Olya, Ola, O, S";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
