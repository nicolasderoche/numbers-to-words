package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.NumbersToWordsApplication;

@SpringBootTest
class NumbersToWordsApplicationTests {

	@Autowired
	private NumbersToWordsApplication controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	@Test
	void checkConversion() {
		assertThat(controller).isNotNull();
		assertThat(controller.convert(444)).isEqualTo("four hundred forty-four");
		assertThat(controller.convert(200)).isEqualTo("two hundred");
		assertThat(controller.convert(200)).contains("hundred");
	}
}
