package com.extractdata.extractdata.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.extractdata.extractdata.model.OutputData;

@Service
public class ExtractDataServiceImpl implements ExtractDataService {

	@Override
	public List<OutputData> extractedData(String str) {
		Pattern p = Pattern.compile("\\d+(,\\d+)*(\\.\\d*)?");
		Matcher m = p.matcher(str);
		List<OutputData> list = new ArrayList<>();
		String group = null;
		while(m.find()) {
			if(m.group().contains(",")) {
				group = m.group().replaceAll(",", "");
			}
			else {
				group = m.group();
			}
			list.add(new OutputData(m.group(), new BigDecimal(group), m.start(), m.end()));
		}

		return list;
	}
}
