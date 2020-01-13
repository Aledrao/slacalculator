package br.com.asas.slacalculator.utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class LocalDateTimeUtils {

	public static boolean isFimSemana(LocalDateTime data) {
		DayOfWeek dayWeek = data.getDayOfWeek();		
		return dayWeek == DayOfWeek.SATURDAY || dayWeek == DayOfWeek.SUNDAY;
	}
	
	public static boolean isFeriado(LocalDateTime data, List<LocalDateTime> feriados) {
		boolean confirmaFeriado = false;
		for(LocalDateTime dataVerificar : feriados) {
			
			if(!confirmaFeriado) {
			confirmaFeriado =  ((dataVerificar.getDayOfMonth() == data.getDayOfMonth())
					&& (dataVerificar.getMonthValue() == data.getMonthValue())
					&& (dataVerificar.getYear() == data.getYear()));
			}
		}
		return confirmaFeriado;
	}
}