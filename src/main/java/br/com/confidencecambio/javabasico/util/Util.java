package br.com.confidencecambio.javabasico.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {

	public static Double limitarDouble(double val, int casas) {
		if (casas < 0) {
			throw new IllegalArgumentException();
		}

		BigDecimal bd = BigDecimal.valueOf(val);
		bd = bd.setScale(casas, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static boolean isNumeric(String str) {
		return str != null && str.matches("^[0-9,;]+$");
	}
}
