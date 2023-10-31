package com.wab.clima.model.pojos.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArrayOfForecastPojo {

	@JsonProperty
	private List<ForecastPojo> list;

	public List<ForecastPojo> getList() {
		return list;
	}

	public void setList(List<ForecastPojo> list) {
		this.list = list;
	}

}
