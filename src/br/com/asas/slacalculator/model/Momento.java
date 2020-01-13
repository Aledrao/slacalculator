package br.com.asas.slacalculator.model;

import java.time.LocalDateTime;

public class Momento {

	private LocalDateTime momento;

	public LocalDateTime getMomento() {
		return momento;
	}

	public void setMomento(LocalDateTime momento) {
		this.momento = momento;
	}

	@Override
	public String toString() {
		return "Momento [momento=" + momento + "]";
	}
}
