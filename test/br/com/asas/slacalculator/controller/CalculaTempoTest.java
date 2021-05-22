package br.com.asas.slacalculator.controller;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculaTempoTest {
	
	CalculaTempo calculaTempo;
	
	@Before
	public void init() {
		calculaTempo = new CalculaTempo();
	}

	@Test
	public void deveriaCalcularHoraCorretamente() throws Exception {
		int horarioInicio = 8;
		int horarioAlmoco = 12;
		int horarioRetorno = 13;
		int horarioFechamento = 17;
		
		int quantidadeHoras = calculaTempo.calculaHorasUteisPorDia(horarioInicio,
				horarioAlmoco, horarioRetorno, horarioFechamento);
		
		assertEquals(quantidadeHoras, 8);
	}
	
	@Test
	public void deveriaCalcularHoraCorretamenteSemAlmoco() throws Exception {
		int horarioInicio = 8;
		int horarioAlmoco = 0;
		int horarioRetorno = 0;
		int horarioFechamento = 17;
		
		int quantidadeHoras = calculaTempo.calculaHorasUteisPorDia(horarioInicio,
				horarioAlmoco, horarioRetorno, horarioFechamento);
		
		assertEquals(quantidadeHoras, 9);
	}
	
	@Test(expected = Exception.class)
	public void deveriaRetornarExcecaoCalculoHoraFaltaHoraAlmoco() throws Exception {
		int horarioInicio = 8;
		int horarioAlmoco = 0;
		int horarioRetorno = 13;
		int horarioFechamento = 17;
		
		calculaTempo.calculaHorasUteisPorDia(horarioInicio,
				horarioAlmoco, horarioRetorno, horarioFechamento);
	}
	
	@Test(expected = Exception.class)
	public void deveriaRetornarExcecaoCalculoHoraFaltaHoraRetorno() throws Exception {
		int horarioInicio = 8;
		int horarioAlmoco = 12;
		int horarioRetorno = 0;
		int horarioFechamento = 17;
		
		calculaTempo.calculaHorasUteisPorDia(horarioInicio,
				horarioAlmoco, horarioRetorno, horarioFechamento);
	}
	
	@Test(expected = Exception.class)
	public void deveriaRetornarExcecaoCalculoHoraInicioFimIguais() throws Exception {
		int horarioInicio = 8;
		int horarioAlmoco = 12;
		int horarioRetorno = 13;
		int horarioFechamento = 8;
		
		calculaTempo.calculaHorasUteisPorDia(horarioInicio,
				horarioAlmoco, horarioRetorno, horarioFechamento);
	}
	
	@Test
	public void deveriaCalcularTempo_sucesso() throws Exception {
		int horarioInicioExpediente = 8;
		int horarioInicioAlmoco = 12;
		int horarioFimAlmoco = 13;
		int horarioFimExpediente = 18;
		LocalDateTime prazoEntrega = LocalDateTime.now().plusDays(1);
		
		int horas = calculaTempo.calcularHoras(horarioInicioExpediente, horarioInicioAlmoco, horarioFimAlmoco, horarioFimExpediente, prazoEntrega);
		
		Assert.assertEquals(24, horas);
	}
}