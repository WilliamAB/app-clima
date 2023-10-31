package com.wab.clima.controller;

import com.wab.clima.model.pojos.LocationPojo;
import com.wab.clima.model.services.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe que contém os acessos de localização.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@GetMapping
	public LocationPojo getLocation(String city, String state) {
		return locationService.findLocation(city, state);
	}

}