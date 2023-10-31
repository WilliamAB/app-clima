package com.wab.clima.model.pojos;

/**
 * Representa uma localização para pesquisa do clima.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public class LocationPojo {

	private int latitude;
	private int longitude;
	private String location;

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
