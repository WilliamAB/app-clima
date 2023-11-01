package com.wab.clima.controller;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.wab.clima.model.entities.WeatherHistory;
import com.wab.clima.model.pojos.ResponsePageablePojo;
import com.wab.clima.model.pojos.WeatherPojo;
import com.wab.clima.model.pojos.WeatherSearchPojo;
import com.wab.clima.model.services.LocationService;
import com.wab.clima.model.services.WeatherService;
import com.wab.clima.model.transform.WeatherPojoTransform;
import com.wab.clima.model.util.AppConstants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe que contém os acessos de consulta de clima/previsão do tempo.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@Tag(name = "weather")
@RestController
@RequestMapping(path = "/weather")
public class WeatherController {

	@Autowired
	private LocationService locationService;
	@Autowired
	private WeatherService weatherService;
	@Autowired
	private WeatherPojoTransform weatherPojoTransform;

	@PostMapping
	public List<WeatherPojo> getWeather(@RequestBody WeatherSearchPojo weatherSearch) {
		List<WeatherHistory> weatherHistories = weatherService.findWeather(weatherSearch);
		return weatherPojoTransform.convertTo(weatherHistories);
	}

	@GetMapping("/history")
	public ResponsePageablePojo<List<WeatherPojo>> getHistory(@RequestParam(defaultValue = "1") int page,
															  @RequestParam(defaultValue = AppConstants.PAGE_LIMIT_STR) int limit) {
		Page<WeatherHistory> weatherHistories = weatherService.findHistory(page, limit);
		return weatherPojoTransform.convertTo(weatherHistories);
	}

}
