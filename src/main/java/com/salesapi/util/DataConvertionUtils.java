package com.salesapi.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataConvertionUtils {
	public static LocalDate getLocalDate(String data) {
		return LocalDate.parse(data.subSequence(0, 10));
	}

	public static LocalDateTime getLocalDateTime(String data) {
		return LocalDateTime.parse(data.subSequence(0, 19));
	}

	public static LocalDateTime getLocalDateTimeByYearMonthDay(String data) {
		LocalDate localDate = LocalDate.parse(data);
		return localDate.atStartOfDay();
	}

	public static String convertDateToDayMonthYearFormat(LocalDateTime date) {

		LocalDate dataToFormatter = date.toLocalDate();
		return dataToFormatter.toString();
	}
	
	public static String convertDateToDayMonthYearFormat1(LocalDate date) {
		return date.toString();
	}

	public static String getStringOfLocalDateTime(LocalDateTime data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return data.format(formatter);
	}
}
