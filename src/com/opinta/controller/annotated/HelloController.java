package com.opinta.controller.annotated;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.opinta.model.Student;
import com.opinta.service.StudentNameEditor;

@Controller
public class HelloController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		// forbid fill this fields from the view by autobinding using ModelAttribute
//		binder.setDisallowedFields("IQ");
		
		// defining format recognition for date input
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy*MM*dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "DOB", customDateEditor);
		// check name with our editor
		PropertyEditorSupport nameEditor = new StudentNameEditor();
		binder.registerCustomEditor(String.class, "name", nameEditor);
	}
	
//	Test Path variable
//	getting parameters from the url
	@RequestMapping(value="/welcome/{name}")
	public ModelAndView HelloWorld(@PathVariable Map<String, String> pathVars) {
		String name = pathVars.get("name");
		
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Hello " + name);
		
		return modelAndView;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView OpenLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("LoginPage");
		// we don't need code above because we use common model attribute in addCommonObject
//		modelAndView.addObject("topmessage", "Here is my simple Spring MVC");
		
		return modelAndView;
	}

//	Test Request parameters
//	getting parameters from the body
	@RequestMapping(value="/submitLogin", method=RequestMethod.POST)
	public ModelAndView SubmitLogin(@RequestParam(value="name") String name) {
		Student student = new Student();
		student.setName(name);
		
		ModelAndView modelAndView = new ModelAndView("WelcomePage");
		modelAndView.addObject("student", student);
		
		return modelAndView;
	}

//	Test Model Attribute
//	getting parameters from the body directly to the model
//	explicit passing parameters to the view 
	@RequestMapping(value="/submitLoginUsingModelAttribute", method=RequestMethod.POST)
	public ModelAndView SubmitLogin(@Valid @ModelAttribute(value="student") Student student, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (result.hasErrors()) {
			modelAndView.setViewName("LoginPage");
		} else {
			modelAndView.setViewName("WelcomePage");
		}
		
		// we don't need code above because we use common model attribute in addCommonObject
//		modelAndView.addObject("topmessage", "Here is my simple Spring MVC");
		
		return modelAndView;
	}
	
//	Add Common Model Attribute
//	if we have model attribute that repeats in every method,
//	then we can add it to the method with @ModelAttribute
//	Spring MVC call this method before each controller
	@ModelAttribute
	public void addCommonObject(Model model) {
		model.addAttribute("topmessage", "Here is my simple Spring MVC");
	}
}
