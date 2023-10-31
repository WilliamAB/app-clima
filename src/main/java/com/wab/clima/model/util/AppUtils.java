package com.wab.clima.model.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Classe com utilitários da aplicação.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public final class AppUtils {

	public static PageRequest createPageable(int page, int limit) {
		if (page < 1) {
			page = 1;
		}

		// A paginação começa em 0, por isso deve reduzir 1
		page -= 1;

		if (limit < 1 || limit > AppConstants.getPageLimit()) {
			limit = AppConstants.getPageLimit();
		}

		return PageRequest.of(page, limit, Sort.by("id"));
	}

}
