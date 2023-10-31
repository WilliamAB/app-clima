package com.wab.clima.model.util;

/**
 * Classe com utilitários de {@link String}.
 *
 * @author William Alberto Bertoldi (william.bertoldi@gmail.com)
 *
 */
public final class StringUtils {

	public static String toSeparatorString(String separator, Object... values) {
		StringBuilder sb = new StringBuilder();

		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				sb.append(values[i]);
				if (i + 1 < values.length) {
					sb.append(separator);
				}
			}
		}

		return sb.toString();
	}

}
