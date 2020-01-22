package br.com.asas.slacalculator.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LocalDateTimeUtilsTest {

	@Test
	public void deveriaConfirmarFimSemana() {
		LocalDateTime data = LocalDateTime.of(2010, 6, 6, 11, 55, 00);

		boolean fimSemana = LocalDateTimeUtils.isFimSemana(data);
		
		assertTrue(fimSemana);
	}
	
	@Test
	public void deveriaConfirmarNaoFimSemana() {
		LocalDateTime data = LocalDateTime.of(2020, 1, 13, 11, 55, 00);

		boolean fimSemana = LocalDateTimeUtils.isFimSemana(data);
		
		assertFalse(fimSemana);
	}
	
	@Test
	public void deveriaConfirmarFeriado() {
		LocalDateTime data = LocalDateTime.of(2020, 5, 1, 11, 55, 00);

		boolean feriado = LocalDateTimeUtils.isFeriado(data, feriados());
		
		assertTrue(feriado);
	}
	
	@Test
	public void naoDeveriaConfirmarFeriado() {
		LocalDateTime data = LocalDateTime.of(2020, 6, 7, 11, 55, 00);

		boolean feriado = LocalDateTimeUtils.isFeriado(data, feriados());
		
		assertFalse(feriado);
	}
	
	private List<LocalDateTime> feriados() {
		List<LocalDateTime> feriados = new ArrayList<>();
		
		LocalDateTime anoNovo = LocalDateTime.of(2020, 1, 1, 0, 0, 0);
		LocalDateTime trabalho = LocalDateTime.of(2020, 5, 1, 0, 0, 0);
		LocalDateTime natal = LocalDateTime.of(2020, 12, 25, 0, 0, 0);
		
		feriados.add(anoNovo);
		feriados.add(trabalho);
		feriados.add(natal);
		
		return feriados;
	}

}
