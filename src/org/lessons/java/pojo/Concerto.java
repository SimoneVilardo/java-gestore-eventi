package org.lessons.java.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Concerto extends Evento {
	
	private LocalTime ora;
	private BigDecimal prezzo;
	

	public Concerto(String titolo, LocalDate data, int postiTotale, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTotale);
		setOra(ora);
		setPrezzo(prezzo);
	}


	public LocalTime getOra() {
		return ora;
	}


	public void setOra(LocalTime ora) {
		this.ora = ora;
	}


	public BigDecimal getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(BigDecimal prezzo) throws Exception {
        if (prezzo.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("Il prezzo non può essere negativo!");
        }
        this.prezzo = prezzo;
    }
	
	private String oraFormattata() {
        return ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    private String prezzoFormattato() {
        return String.format("%.2f€", prezzo);
    }

    @Override
    public String toString() {
        return super.dataFormattata() + " " + oraFormattata() + " - " + getTitolo() + " - " + prezzoFormattato() + " x" + super.getPostiPrenotati();
    }
	
}
