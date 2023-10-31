package com.wab.clima.model.pojos;

/**
 * Representa uma localização para pesquisa do clima.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public class LocationPojo {

	private Long id;
	private String city;
	private String state;
	private String country;
	private double latitude;
	private double longitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
