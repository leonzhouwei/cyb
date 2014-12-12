package com.example.cyb.webapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(BaseRoute.HELLO)
	public String hello() {
		return " world";
	}

}
