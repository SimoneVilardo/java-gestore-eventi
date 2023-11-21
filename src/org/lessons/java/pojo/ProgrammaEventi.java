package org.lessons.java.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
	
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammaEventi(String titolo) {
		
		setTitolo(titolo);
		setEventi(new ArrayList<>());
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	public void aggiungiEvento(Evento evento) {
        getEventi().add(evento);
    }
	
	public List<Evento> getEventiFiltrati(LocalDate data){
		
		 List<Evento> eventiFiltrati = new ArrayList<>();
		 
		 for (Evento evento : getEventi()) {
			 
	            if (evento.getData().isEqual(data)) {
	            	
	                eventiFiltrati.add(evento);
	                
	            }
	        }
		 
        return eventiFiltrati;
	}
	
	public int numeroEventi() {
		
		return getEventi().size();
		
	}
	
	public void svuotaEventi() {
		
		getEventi().clear();
		
	}
	
	public String visualizzaProgramma(List<Evento> eventi) {

        eventi.sort(Comparator.comparing(evento -> evento.getData()));
        
        String str = getTitolo() + "\n-------------------\n";
        
        for (Evento evento : eventi) {
            
            String data = evento.dataFormattata();
            
            String titolo = evento.getTitolo();
            
            str = str + data + " - " + titolo + "\n";
        }
        
        return str;
    }
}
