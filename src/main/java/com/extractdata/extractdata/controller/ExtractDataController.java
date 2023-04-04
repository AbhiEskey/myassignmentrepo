package com.extractdata.extractdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.extractdata.extractdata.model.ExtractedResponse;
import com.extractdata.extractdata.model.InputData;
import com.extractdata.extractdata.model.OutputData;
import com.extractdata.extractdata.service.ExtractDataServiceImpl;

@RestController
public class ExtractDataController {
	
	@Autowired
	ExtractDataServiceImpl extractDataService;
	
	@PostMapping(value="/extractData")
	public ExtractedResponse extractData(@RequestBody InputData data) {
		List<OutputData> outData = extractDataService.extractedData(data.getText());
		return new ExtractedResponse(data.getId(), outData);
	}
	
	@GetMapping("/hello")
	public String hellow() {
		return "Hellow World!";
	}

}
