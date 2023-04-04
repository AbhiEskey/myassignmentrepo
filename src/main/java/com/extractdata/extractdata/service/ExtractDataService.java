package com.extractdata.extractdata.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.extractdata.extractdata.model.OutputData;

@Component
public interface ExtractDataService {

	List<OutputData> extractedData(String str);

}
