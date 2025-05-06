package it.novello.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConversion {
	
	public Date fromStringToDate(String input) {
		Date output = null;
		DateFormat setting = new SimpleDateFormat("dd/MM/yyyy");
		try {
			output = new Date(setting.parse(input).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public String fromDateToString(Date input) {
		String output = null;
		DateFormat setting = new SimpleDateFormat("dd/MM/yyyy"); //yyyy-MM-dd
		output = new String(setting.format(input));
		return output;
	}
}
