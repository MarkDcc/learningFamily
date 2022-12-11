package com.gordon.demospringmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:dongchen
 * @Date: 2022/12/4 14:19
 */
@RestController
public class Main {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}

	@GetMapping("/call/{name}")
	public String call(@PathVariable("name")String name){
		return name;
	}
}
