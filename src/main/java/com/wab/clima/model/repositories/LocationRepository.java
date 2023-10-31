package com.wab.clima.model.repositories;

import com.wab.clima.model.entities.Location;

import org.springframework.data.repository.CrudRepository;

/**
 * Repositório de dados para {@link Location}.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public interface LocationRepository extends CrudRepository<Location, Long> {

	Location findByCityAndState(String city, String state);

}
