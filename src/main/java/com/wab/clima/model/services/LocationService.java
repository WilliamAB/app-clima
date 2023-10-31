package com.wab.clima.model.services;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.wab.clima.model.pojos.api.GeoLocationPojo;
import com.wab.clima.model.pojos.LocationPojo;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Serviço para busca das localizações na API GEO.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
@Service
public class LocationService {

	@Value("${app.clima.openweather.appid}")
	private String appid;
	@Value("${app.clima.openweather.apigeo.url}")
	private String urlApiGeo;

	/**
	 * Busca informações mais detalhadas de geolocalização de uma cidade.
	 * O resultado pode ser uma lista de cidades com nomes parecidos.
	 *
	 * @param city o nome da cidade
	 * @return uma lista de geolocalizações
	 */
	public List<GeoLocationPojo> findGeoLocations(String city) {

		HttpUrl.Builder urlBuilder = HttpUrl.parse(urlApiGeo).newBuilder();
		urlBuilder.addQueryParameter("q", city);
		urlBuilder.addQueryParameter("limit", "5");
		urlBuilder.addQueryParameter("appid", appid);

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(urlBuilder.build().url()).build();

		try (Response response = client.newCall(request).execute()) {
			ResponseBody body = response.body();
			if (body != null) {
				ObjectMapper mapper = new ObjectMapper();
				CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, GeoLocationPojo.class);
				return mapper.readValue(body.string(), collectionType);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return Collections.emptyList();
	}

	/**
	 * Busca os dados de localização da uma cidade.
	 *
	 * @param city o nome da cidade
	 * @param state o nome do estado
	 * @return o pojo com os dados da localização
	 */
	public LocationPojo findLocation(String city, String state) {

		if (city == null) {
			return null;
		}

		Optional<GeoLocationPojo> optGeoLocation = findGeoLocations(city).stream()
				.filter(l -> {
					return Objects.equals(city, l.getName())
							&& (state == null
							|| state.isBlank()
							|| Objects.equals(state, l.getState()));
				}).findFirst();

		if (optGeoLocation.isPresent()) {
			GeoLocationPojo geoLocation = optGeoLocation.get();

			String locationFmt = "%s, %s - %s".formatted(geoLocation.getName(), geoLocation.getState(), geoLocation.getCountry());

			LocationPojo location = new LocationPojo();

			location.setLocation(locationFmt);
			location.setLatitude(geoLocation.getLat());
			location.setLongitude(geoLocation.getLon());

			return location;
		}

		return null;
	}

}
