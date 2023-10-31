package com.wab.clima.model.services;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wab.clima.model.entities.Location;
import com.wab.clima.model.entities.WeatherHistory;
import com.wab.clima.model.pojos.WeatherSearchPojo;
import com.wab.clima.model.pojos.api.ArrayOfForecastPojo;
import com.wab.clima.model.pojos.api.ForecastPojo;
import com.wab.clima.model.repositories.WeatherHistoryRepository;
import com.wab.clima.model.util.AppConstants;
import com.wab.clima.model.util.AppUtils;
import com.wab.clima.model.util.DateUtils;
import com.wab.clima.model.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Serviço para busca das informações meteorológicas na API de previsão de 5 dias.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@Service
public class WeatherService {

	@Value("${app.clima.openweather.appid}")
	private String appid;
	@Value("${app.clima.openweather.api.url}")
	private String urlApi;

	@Autowired
	private LocationService locationService;
	@Autowired
	private WeatherHistoryRepository weatherHistoryRepository;

	public List<ForecastPojo> findWeather(double latitude, double longitude, String language, String units) {

		HttpUrl.Builder urlBuilder = HttpUrl.parse(urlApi).newBuilder();
		urlBuilder.addQueryParameter("lat", String.valueOf(latitude));
		urlBuilder.addQueryParameter("lon", String.valueOf(longitude));
		urlBuilder.addQueryParameter("lang", language != null ? language : AppConstants.getLanguage());
		urlBuilder.addQueryParameter("units", units != null ? units : AppConstants.getUnits());
		urlBuilder.addQueryParameter("appid", appid);

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(urlBuilder.build().url()).build();

		try (Response response = client.newCall(request).execute()) {
			ResponseBody body = response.body();
			if (body != null) {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.readValue(body.string(), ArrayOfForecastPojo.class).getList();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return Collections.emptyList();
	}

	public List<WeatherHistory> findWeather(WeatherSearchPojo weatherSearch) {

		Location location = locationService.findLocation(weatherSearch.getCity(), weatherSearch.getState());

		if (location == null) {
			return Collections.emptyList();
		}

		List<ForecastPojo> forecasts = findWeather(location.getLatitude(), location.getLongitude(),
				weatherSearch.getLanguage(), weatherSearch.getUnits());

		return forecasts.stream().map(f -> {
			WeatherHistory weatherEntity = new WeatherHistory();
			weatherEntity.setForecastDateTime(DateUtils.convertToLocalDateTime(f.getDt(), weatherSearch.getZoneId()));
			weatherEntity.setTemp(f.getMain().getTemp());
			weatherEntity.setTempMin(f.getMain().getTemp_min());
			weatherEntity.setTempMax(f.getMain().getTemp_max());
			weatherEntity.setRainProbability((int) (f.getPop() * 100));
			weatherEntity.setDescription(StringUtils.toSeparatorString(", ", f.getWeather().stream().map(ForecastPojo.ForecastWeatherPojo::getDescription).toArray()));
			weatherEntity.setLocation(location);
			weatherEntity.setSearchDateTime(LocalDateTime.now());

			weatherHistoryRepository.save(weatherEntity);

			return weatherEntity;
		}).collect(Collectors.toList());
	}

	public Page<WeatherHistory> findHistory(int page, int limit) {
		return weatherHistoryRepository.findAll(AppUtils.createPageable(page, limit));
	}

}
