package com.extractdata.extractdata.model;

import java.io.Serializable;
import java.util.List;

public class ExtractedResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private List<OutputData> outputDataList;

	public ExtractedResponse() {
		super();
	}

	public ExtractedResponse(String id, List<OutputData> outputDataList) {
		super();
		this.id = id;
		this.outputDataList = outputDataList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<OutputData> getOutputDataList() {
		return outputDataList;
	}

	public void setOutputDataList(List<OutputData> outputDataList) {
		this.outputDataList = outputDataList;
	}

}
