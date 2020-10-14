package com.dsurchin.movielibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@RequestMapping("/list")
	public String listMovie (Model model) {
		
		return "list-movies";
	}

}
