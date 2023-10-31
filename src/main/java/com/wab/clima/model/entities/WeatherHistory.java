package com.wab.clima.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;

/**
 * Representa um histórico de pesquisa de clima.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@Entity
@Table(name = "weather_history")
public class WeatherHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime forecastDateTime;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Double temp;

	@Column(nullable = false)
	private Double tempMin;

	@Column(nullable = false)
	private Double tempMax;

	@Column(nullable = false)
	private Integer rainProbability;

	@JoinColumn(nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Location location;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime searchDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getForecastDateTime() {
		return forecastDateTime;
	}

	public void setForecastDateTime(LocalDateTime forecastDateTime) {
		this.forecastDateTime = forecastDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getTempMin() {
		return tempMin;
	}

	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}

	public Double getTempMax() {
		return tempMax;
	}

	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}

	public Integer getRainProbability() {
		return rainProbability;
	}

	public void setRainProbability(Integer rainProbability) {
		this.rainProbability = rainProbability;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public LocalDateTime getSearchDateTime() {
		return searchDateTime;
	}

	public void setSearchDateTime(LocalDateTime searchDateTime) {
		this.searchDateTime = searchDateTime;
	}

}
