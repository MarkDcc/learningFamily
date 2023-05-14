package com.example.security01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:dongchen
 * @Date: 2023/5/8 21:44
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
}
