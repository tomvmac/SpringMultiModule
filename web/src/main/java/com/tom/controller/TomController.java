package com.tom.controller;

import com.tom.domainobject.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class TomController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String index(ModelMap model){
		Person person = new Person("api", "");
		model.addAttribute("person", person);
		return "hello";
	}

	@RequestMapping(value = "/sayhello/{firstName}", method = RequestMethod.GET)
	public String sayHello(@PathVariable String firstName, ModelMap model){
		Person person = new Person(firstName, "Mac");
		model.addAttribute("person", person);

		return "hello";
	}

	@RequestMapping("/person")
	@ResponseBody
	public Person getPerson(){
		return new Person("Tom", "Mac");
	}



}