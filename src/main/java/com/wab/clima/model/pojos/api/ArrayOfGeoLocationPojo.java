package com.wab.clima.model.pojos.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArrayOfGeoLocationPojo {

	@JsonProperty
	private List<GeoLocationPojo> geoLocationPojos;

	public List<GeoLocationPojo> getGeoLocationPojos() {
		return geoLocationPojos;
	}

	public void setGeoLocationPojos(List<GeoLocationPojo> geoLocationPojos) {
		this.geoLocationPojos = geoLocationPojos;
	}
}
