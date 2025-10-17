package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NumbersToWordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumbersToWordsApplication.class, args);
	}

	@GetMapping("/convert")
	public String convert(@RequestParam(value = "value") int value) {
		return (new NumbersToWords()).convert(value);
	}
}
