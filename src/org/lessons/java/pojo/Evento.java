package org.lessons.java.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String titolo;
	private LocalDate data;
	private int postiTotale;
	private int postiPrenotati;
	
	public Evento(String titolo, LocalDate data, int postiTotale) throws Exception {
		
		setTitolo(titolo);
		setData(data);
		setPostiTotale(postiTotale);
		setPostiPrenotati(0);
		
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		
		if (data.isBefore(LocalDate.now())) {
			
			throw new Exception("La data che hai inserito è già passata!");
		}
		
		this.data = data;
	}

	public int getPostiTotale() {
		return postiTotale;
	}

	private void setPostiTotale(int postiTotale) throws Exception {
		
		if (postiTotale <= 0) {
			throw new Exception("I posti non possono essere minori di 0!");
		}
		
		this.postiTotale = postiTotale;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	private void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}
	
	public void prenota() throws Exception {
		
		if (getData().isBefore(LocalDate.now())) {
			throw new Exception("La data selezionata è già passata!");
		}
		
		if (getPostiTotale() == getPostiPrenotati() ) {
			throw new Exception("Non ci sono più posti disponibili!");
		}
		
		setPostiPrenotati(getPostiPrenotati() + 1);
		
	}
	
	public void disdici() throws Exception {
		
		if (getData().isBefore(LocalDate.now())) {
			throw new Exception("La data selezionata è già passata!");
		}
		
		if (getPostiPrenotati() == 0 ) {
			throw new Exception("Non ci sono prenotazioni per questo evento!");
		}
		
		setPostiPrenotati(getPostiPrenotati() - 1);
	}
	
	
	protected String dataFormattata() {
		
		 String dataFormattata = getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		return dataFormattata;
	}
	
	@Override
	public String toString() {
		
		return dataFormattata() + " - " + getTitolo() + "\n"
				+ "Posti Totali: " + getPostiTotale() + "\n"
				+ "Numero di posti prenotati: " + getPostiPrenotati() + "\n"
				+ "Numero di posti disponibili: " + (getPostiTotale() - getPostiPrenotati());
	}
}



