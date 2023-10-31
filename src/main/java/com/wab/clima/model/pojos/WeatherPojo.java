package com.wab.clima.model.pojos;

import java.time.LocalDateTime;

public class WeatherPojo {

	private Long id;
	private LocalDateTime forecastDateTime;
	private String description;
	private double temp;
	private double tempMin;
	private double tempMax;
	private int rainProbability;
	private LocalDateTime searchDateTime;
	private LocationPojo location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getForecastDateTime() {
		return forecastDateTime;
	}

	public void setForecastDateTime(LocalDateTime localDateTime) {
		this.forecastDateTime = localDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public double getTempMin() {
		return tempMin;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	public int getRainProbability() {
		return rainProbability;
	}

	public void setRainProbability(int rainProbability) {
		this.rainProbability = rainProbability;
	}

	public LocalDateTime getSearchDateTime() {
		return searchDateTime;
	}

	public void setSearchDateTime(LocalDateTime searchDateTime) {
		this.searchDateTime = searchDateTime;
	}

	public LocationPojo getLocation() {
		return location;
	}

	public void setLocation(LocationPojo location) {
		this.location = location;
	}

}
