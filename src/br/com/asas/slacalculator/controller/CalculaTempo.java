package br.com.asas.slacalculator.controller;

import java.time.LocalDateTime;
import java.util.List;

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
			throw new Exception("Caso a hora de almo�o seja diferente de zero, � necess�rio informar a hora de retorno e vice-versa.");
		}
		
		return totalHoras;
	}
	
	public int adicionarHoras(LocalDateTime dataInicio, int horaInicio, int horaAlmoco, int horaRetorno, int horaFinal,
			boolean fimSemana, List<LocalDateTime> feriados) throws Exception {
		int diaInformado = dataInicio.getDayOfMonth();
		int mesInformado = dataInicio.getMonthValue();
		int anoInformado = dataInicio.getYear();
		int horaInformado = dataInicio.getHour();
		int minutoInformado = dataInicio.getMinute();
		int segundoInformado = dataInicio.getSecond();
		
		LocalDateTime agora = LocalDateTime.now();
		
		if(dataInicio.getYear() <= agora.getYear()) {
			if(dataInicio.getHour() > horaInicio && dataInicio.getHour() < horaAlmoco) {
				
			}
		} else {
			throw new Exception("A data e hora informada precisa ser maior ou igual a data e hora atual.");
		}
		
		int totalHoras = 0;
		
				
		
		return totalHoras;
	}

	public int calcularHorasFaltantes(int horarioInicioExpediente, int horarioInicioAlmoco, int horarioFimAlmoco,
									  int horarioFimExpediente, LocalDateTime prazoEntrega) {
		//Transforma a data e hora informada.
		int diaPrazo = prazoEntrega.getDayOfMonth();
		int mesPrazo = prazoEntrega.getMonthValue();
		int anoPrazo = prazoEntrega.getYear();
		int horaPrazo = prazoEntrega.getHour();
		int minutoPrazo = prazoEntrega.getMinute();
		int segundoPrazo = prazoEntrega.getSecond();
		
		//Transforma a data e hora atual
		LocalDateTime agora = LocalDateTime.now();
		int diaAgora = agora.getDayOfMonth();
		int mesAgora = agora.getMonthValue();
		int anoAgora = agora.getYear();
		int horaAgora = agora.getHour();
		int minutoAgora = agora.getMinute();
		int segundoAgora = agora.getSecond();
		
		int segundosCalculados = calculaSegundosFaltantes(segundoPrazo, segundoAgora);
		int minutosCalculados = calculaMinutosFaltantes(minutoPrazo, minutoAgora);
		
		return 0;
	}

	private int calculaSegundosFaltantes(int segundoPrazo, int segundoAgora) {
		if(segundoPrazo > segundoAgora) {
			return segundoPrazo - segundoAgora;
		}
		return segundoAgora - segundoPrazo;
	}

	private int calculaMinutosFaltantes(int minutoPrazo, int minutoAgora) {
		if(minutoPrazo > minutoPrazo) {
			return minutoPrazo - minutoAgora;
		}
		return minutoAgora - minutoPrazo;
	}
}
