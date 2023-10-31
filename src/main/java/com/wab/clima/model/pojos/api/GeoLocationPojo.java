package com.wab.clima.model.pojos.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representação da resposta da API de geolocalização.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocationPojo {

	@JsonProperty
	private String name;
	@JsonProperty
	private double lat;
	@JsonProperty
	private double lon;
	@JsonProperty
	private String country;
	@JsonProperty
	private String state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
