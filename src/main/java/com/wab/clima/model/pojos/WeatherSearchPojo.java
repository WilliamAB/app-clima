package com.wab.clima.model.pojos;

/**
 * Representa os parâmetros para pesquisa do clima.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public class WeatherSearchPojo {

	private String city;
	private String state;
	private String language;
	private String units;
	private String zoneId;

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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

}
