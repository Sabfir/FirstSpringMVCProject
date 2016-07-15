package com.opinta.service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<IsValidName, String>{
	private String listOfNames;
	
	@Override
	public void initialize(IsValidName isValidName) {
		this.listOfNames = isValidName.listOfNames();
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext ctx) {
		String nameFound = name;
		if (name.substring(0, 4).matches("Mr. |Ms. ")) {
			nameFound = name.substring(4);
		}
		System.out.println("name:" + nameFound);
		
		if (nameFound.isEmpty()) {
			return false;
		}
		if (!listOfNames.isEmpty() && !nameFound.matches(listOfNames)) {
			return false;
		}
		
		return true;
	}
	
}
