package com.extractdata.extractdata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.extractdata.extractdata.controller.ExtractDataController;

@SpringBootTest
class ExtractdataApplicationTests {

	@Autowired
	private ExtractDataController extractDataController;
	
	@Test
	void contextLoads() {
		Assertions.assertThat(extractDataController).isNotNull();
	}

}
