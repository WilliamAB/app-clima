package com.wab.clima.model.transform;

import com.wab.clima.model.entities.WeatherHistory;
import com.wab.clima.model.pojos.ResponsePageablePojo;
import com.wab.clima.model.pojos.WeatherPojo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class WeatherPojoTransform {

	@Autowired
	private LocationPojoTransform locationPojoTransform;

	public WeatherPojo convertTo(WeatherHistory entity) {
		WeatherPojo pojo = new WeatherPojo();
		pojo.setId(entity.getId());
		pojo.setDescription(entity.getDescription());
		pojo.setTemp(entity.getTemp());
		pojo.setTempMin(entity.getTempMin());
		pojo.setTempMax(entity.getTempMax());
		pojo.setRainProbability(entity.getRainProbability());
		pojo.setForecastDateTime(entity.getForecastDateTime());
		pojo.setSearchDateTime(entity.getSearchDateTime());
		pojo.setLocation(locationPojoTransform.convertTo(entity.getLocation()));
		return pojo;
	}

	public WeatherHistory convertFrom(WeatherPojo pojo) {
		WeatherHistory entity = new WeatherHistory();
		entity.setId(pojo.getId());
		entity.setDescription(pojo.getDescription());
		entity.setTemp(pojo.getTemp());
		entity.setTempMin(pojo.getTempMin());
		entity.setTempMax(pojo.getTempMax());
		entity.setRainProbability(pojo.getRainProbability());
		entity.setForecastDateTime(pojo.getForecastDateTime());
		entity.setSearchDateTime(pojo.getSearchDateTime());
		entity.setLocation(locationPojoTransform.convertFrom(pojo.getLocation()));
		return entity;
	}

	public List<WeatherPojo> convertTo(Collection<WeatherHistory> entities) {
		return entities.stream().map(this::convertTo).collect(Collectors.toList());
	}

	public List<WeatherHistory> convertFrom(Collection<WeatherPojo> pojos) {
		return pojos.stream().map(this::convertFrom).collect(Collectors.toList());
	}

	public ResponsePageablePojo<List<WeatherPojo>> convertTo(Page<WeatherHistory> pageEntities) {
		return new ResponsePageablePojo<>(convertTo(pageEntities.toList()), pageEntities);
	}

}
