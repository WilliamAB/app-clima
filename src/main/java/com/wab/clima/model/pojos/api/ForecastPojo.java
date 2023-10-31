package com.wab.clima.model.pojos.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastPojo {

	@JsonProperty
	private long dt;

	@JsonProperty
	private double pop;

	@JsonProperty
	private ForecastMainPojo main;

	@JsonProperty
	private List<ForecastWeatherPojo> weather;

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public double getPop() {
		return pop;
	}

	public void setPop(double pop) {
		this.pop = pop;
	}

	public ForecastMainPojo getMain() {
		return main;
	}

	public void setMain(ForecastMainPojo main) {
		this.main = main;
	}

	public List<ForecastWeatherPojo> getWeather() {
		return weather;
	}

	public void setWeather(List<ForecastWeatherPojo> weather) {
		this.weather = weather;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ForecastWeatherPojo {

		@JsonProperty
		private String description;

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ForecastMainPojo {

		@JsonProperty
		private double temp;

		@JsonProperty
		private double temp_min;

		@JsonProperty
		private double temp_max;

		public double getTemp() {
			return temp;
		}

		public void setTemp(double temp) {
			this.temp = temp;
		}

		public double getTemp_min() {
			return temp_min;
		}

		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}

		public double getTemp_max() {
			return temp_max;
		}

		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}
	}

}
