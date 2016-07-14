package com.opinta.controller.annotated;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.opinta.model.Student;

@Controller
public class HelloController {
	
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
		
		return modelAndView;
	}

//	Test Request parameters
//	getting parameters from the body
	@RequestMapping(value="/submitLogin", method=RequestMethod.POST)
	public ModelAndView SubmitLogin(@RequestParam(value="name") String name,
									@RequestParam(value="hobby") String hobby) {
		Student student = new Student();
		student.setName(name);
		student.setHobby(hobby);
		
		ModelAndView modelAndView = new ModelAndView("WelcomePage");
		modelAndView.addObject("student", student);
		
		return modelAndView;
	}

//	Test Model Attribute
//	getting parameters from the body directly to the model
//	explicit passing parameters to the view 
	@RequestMapping(value="/submitLoginUsingModelAttribute", method=RequestMethod.POST)
	public ModelAndView SubmitLogin(@ModelAttribute(value="student") Student student) {
		ModelAndView modelAndView = new ModelAndView("WelcomePage");
		
		return modelAndView;
	}

}
