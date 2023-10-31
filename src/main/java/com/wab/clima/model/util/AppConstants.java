package com.wab.clima.model.util;

public final class AppConstants {

	private static final String LANGUAGE = "pt_br";
	private static final String UNITS = "metric";
	private static final int PAGE_LIMIT = 20;
	public static final String PAGE_LIMIT_STR = "20";

	public static String getLanguage() {
		return LANGUAGE;
	}

	public static String getUnits() {
		return UNITS;
	}

	public static int getPageLimit() {
		return PAGE_LIMIT;
	}

}
