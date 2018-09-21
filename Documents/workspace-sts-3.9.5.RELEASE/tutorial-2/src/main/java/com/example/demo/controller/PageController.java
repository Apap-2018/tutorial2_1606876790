package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge/","challenge/{name}"})
	public String challengePage(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name",  "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String viralgenerator(@RequestParam(value="a", defaultValue="0") String a, @RequestParam(value="b", defaultValue="0") String b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b",b);
		int a1 = Integer.parseInt(a);
		int b1 = Integer.parseInt(b);
		
		if(a1 == 0) {a1 = 1;}
		if (b1 == 0) {	b1 = 1;}
		
		String totalhm = "h";
		for(int i=0;i<a1; i++) {
			totalhm += "m";
		}
		
		String text = "";
		for(int x=0;x<b1;x++) {
			text += (totalhm + " ");
		}
		
		System.out.println(text);
		  model.addAttribute("text", text);
		  return "generator";
	}
}
