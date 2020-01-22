package br.com.asas.slacalculator.controller;

public class CalculaTempo {
	
	public int calculaHorasUteisPorDia(int horaInicio, int horaAlmoco, int horaRetorno, int horaFinal) throws Exception {
		int totalHoras = 0;
		
		if(horaAlmoco == 0 && horaRetorno == 0) {
			totalHoras = horaFinal - horaInicio;
		}
		else if(horaInicio == horaFinal) {
			throw new Exception("As horasInicio e fim devem ser diferentes.");
		}
		else if(horaAlmoco != 0 && horaRetorno != 0) {
			int horasComeco = horaAlmoco - horaInicio;
			int horaFim = horaFinal - horaRetorno;
			totalHoras = horasComeco + horaFim;
		}		
		else {
			throw new Exception("Caso a hora de almoço seja diferente de zero, é necessário informar a hora de retorno e vice-versa.");
		}
		
		return totalHoras;
	}

}
