package com.wab.clima.model.repositories;

import com.wab.clima.model.entities.WeatherHistory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositório de dados para {@link WeatherHistory}.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public interface WeatherHistoryRepository extends CrudRepository<WeatherHistory, Long> {

	Page<WeatherHistory> findAll(Pageable pageable);

}
