package com.example.cyb.webapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(BaseRoute.ROOT)
	public String index() {
		return "index";
	}

}
