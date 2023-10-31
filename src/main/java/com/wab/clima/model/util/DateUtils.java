package com.wab.clima.model.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Classe com utilitários de data.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public final class DateUtils {

	/**
	 * Converte o timestamp de segundo para um {@link LocalDateTime}.
	 */
	public static LocalDateTime convertToLocalDateTime(long timestamp, String zoneId) {
		Instant instant = Instant.ofEpochSecond(timestamp);
		ZoneId zone = getZone(zoneId);
		return instant.atZone(zone).toLocalDateTime();
	}

	/**
	 * Retorna o {@link ZoneId} correspondente, se informado, ou retorna o padrão do sistema.
	 */
	public static ZoneId getZone(String zoneId) {
		if (zoneId == null) {
			return ZoneId.systemDefault();
		} else {
			return ZoneId.of(zoneId);
		}
	}

}
