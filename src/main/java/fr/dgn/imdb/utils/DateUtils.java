package fr.dgn.imdb.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.commons.lang3.math.NumberUtils;

public class DateUtils {

	public static LocalDate parse(String chaine) {
		if (chaine==null) {
			return null;
		}
		String[] tokens = chaine.trim().split(" ", -1);
		if (tokens.length==3) {
			if (NumberUtils.isDigits(chaine.substring(0, 1))) {
				return LocalDate.parse(chaine, DateTimeFormatter.ofPattern("d MMMM yyyy"));
			}
			else {
				return LocalDate.parse(chaine, DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.US));
			}
		}
		return null;
	}

}
