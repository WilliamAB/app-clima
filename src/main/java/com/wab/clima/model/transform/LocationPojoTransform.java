package com.wab.clima.model.transform;

import com.wab.clima.model.entities.Location;
import com.wab.clima.model.pojos.LocationPojo;

import org.springframework.stereotype.Service;

@Service
public class LocationPojoTransform {

	public LocationPojo convertTo(Location entity) {
		LocationPojo pojo = new LocationPojo();
		pojo.setId(entity.getId());
		pojo.setCity(entity.getCity());
		pojo.setState(entity.getState());
		pojo.setCountry(entity.getCountry());
		pojo.setLatitude(entity.getLatitude());
		pojo.setLongitude(entity.getLongitude());
		return pojo;
	}

	public Location convertFrom(LocationPojo pojo) {
		Location entity = new Location();
		entity.setId(pojo.getId());
		entity.setCity(pojo.getCity());
		entity.setState(pojo.getState());
		entity.setCountry(pojo.getCountry());
		entity.setLatitude(pojo.getLatitude());
		entity.setLongitude(pojo.getLongitude());
		return entity;
	}

}
