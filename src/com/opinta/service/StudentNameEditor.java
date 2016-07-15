package com.opinta.service;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String name) throws IllegalArgumentException {
		if (name.contains("Mr. ") || name.contains("Ms. ")) {
			setValue(name);
		} else {
			name = "Ms. " + name;
			setValue(name);
		}
	}
}
