package com.extractdata.extractdata.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OutputData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String extractedText;
	private BigDecimal extractedValue;
	private Integer startPosition;
	private Integer endPosition;

	public OutputData() {
		super();
	}

	public OutputData(String extractedText, BigDecimal extractedValue, Integer startPosition, Integer endPosition) {

		this.extractedText = extractedText;
		this.extractedValue = extractedValue;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}

	public String getExtractedText() {
		return extractedText;
	}
	public void setExtractedText(String extractedText) {
		this.extractedText = extractedText;
	}
	public BigDecimal getExtractedValue() {
		return extractedValue;
	}
	public void setExtractedValue(BigDecimal extractedValue) {
		this.extractedValue = extractedValue;
	}
	public Integer getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(Integer startPosition) {
		this.startPosition = startPosition;
	}
	public Integer getEndPosition() {
		return endPosition;
	}
	public void setEndPosition(Integer endPosition) {
		this.endPosition = endPosition;
	}



}
