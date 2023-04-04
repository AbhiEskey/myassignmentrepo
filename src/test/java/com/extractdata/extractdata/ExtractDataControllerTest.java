package com.extractdata.extractdata;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.extractdata.extractdata.model.ExtractedResponse;
import com.extractdata.extractdata.model.InputData;
import com.extractdata.extractdata.model.OutputData;
import com.extractdata.extractdata.service.ExtractDataServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ExtractDataControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	ExtractDataServiceImpl extractDataService;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void extractDataTest() throws Exception{

		InputData inputData = new InputData("04a63473-b370-4026-9af8-dbc576cebd87","Take immediate action to stop the violation and notify King County Industrial Waste within 24 hours of learning of the violation. In case of violation penanly of $1,000,000 should be paid with in 3 months.");

		List<OutputData> list = new ArrayList<>();
		list.add(new OutputData("24", new BigDecimal(24), 91, 93));
		list.add(new OutputData("1,000,000", new BigDecimal(1000000), 163, 172));
		list.add(new OutputData("3", new BigDecimal(3), 196, 197));

		when(extractDataService.extractedData(inputData.getText())).thenReturn(list);

		MvcResult result = mvc.perform(post("/extractData")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(inputData))
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andReturn();

		ExtractedResponse response = objectMapper.readValue(result.getResponse().getContentAsString(),ExtractedResponse.class);

		Assertions.assertThat(response.getId()).isEqualTo("04a63473-b370-4026-9af8-dbc576cebd87");

		Assertions.assertThat(response.getOutputDataList().get(0).getExtractedText()).isEqualTo("24");
		Assertions.assertThat(response.getOutputDataList().get(0).getExtractedValue()).isEqualTo(new BigDecimal(24));
		Assertions.assertThat(response.getOutputDataList().get(0).getStartPosition()).isEqualTo(91);
		Assertions.assertThat(response.getOutputDataList().get(0).getEndPosition()).isEqualTo(93);

		Assertions.assertThat(response.getOutputDataList().get(1).getExtractedText()).isEqualTo("1,000,000");
		Assertions.assertThat(response.getOutputDataList().get(1).getExtractedValue()).isEqualTo(new BigDecimal(1000000));
		Assertions.assertThat(response.getOutputDataList().get(1).getStartPosition()).isEqualTo(163);
		Assertions.assertThat(response.getOutputDataList().get(1).getEndPosition()).isEqualTo(172);

		Assertions.assertThat(response.getOutputDataList().get(2).getExtractedText()).isEqualTo("3");
		Assertions.assertThat(response.getOutputDataList().get(2).getExtractedValue()).isEqualTo(new BigDecimal(3));
		Assertions.assertThat(response.getOutputDataList().get(2).getStartPosition()).isEqualTo(196);
		Assertions.assertThat(response.getOutputDataList().get(2).getEndPosition()).isEqualTo(197);
	}

}
