package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.lessons.java.pojo.Concerto;
import org.lessons.java.pojo.Evento;
import org.lessons.java.pojo.ProgrammaEventi;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Inserisci Titolo Programma Eventi: ");
		String titoloProgramma = in.nextLine();
		
		ProgrammaEventi p = new ProgrammaEventi(titoloProgramma);
		
		while (true) {
			
			System.out.println("Titolo Evento: ");
			String titolo = in.nextLine();
			
			System.out.print("Data (formato dd/MM/yyyy): ");
			String dataString = in.nextLine();
			LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			System.out.println("Numero di posti totali disponibili: ");
			String strPostiTotali = in.nextLine();
			int postiTotali = Integer.valueOf(strPostiTotali);
			
			System.out.println("Scegli il tipo di evento (Evento/Concerto): ");
			String tipoEvento = in.nextLine().toLowerCase();
			
			
			Evento evento = null;
			
			try {
				
				if (tipoEvento.equals("evento")) {
					evento = new Evento(titolo, data, postiTotali);
					
				} else if (tipoEvento.equals("concerto")) {
					System.out.print("Ora (formato HH:mm): ");
					String oraString = in.nextLine();
					LocalTime ora = LocalTime.parse(oraString, DateTimeFormatter.ofPattern("HH:mm"));
					
					System.out.print("Prezzo: ");
					String prezzoString = in.nextLine();
					BigDecimal prezzo = new BigDecimal(prezzoString);
					
					evento = new Concerto(titolo, data, postiTotali, ora, prezzo);
					
				} else {
					
					System.out.println("Tipo di evento non valido.");
					
				}
				
				p.aggiungiEvento(evento);
				
				System.out.print("Vuoi effettuare delle prenotazioni? (si/no): ");
				String risposta = in.nextLine();
				
				if (risposta.equals("si")) {
					
					System.out.print("Quante prenotazioni vuoi effettuare? ");
					String strNumeroPrenotazioni = in.nextLine();
					int numeroPrenotazioni = Integer.valueOf(strNumeroPrenotazioni);
					
					if (numeroPrenotazioni > 0) {
						
						for (int i = 0; i < numeroPrenotazioni; i++) {
							
							evento.prenota();
						}					
					}else {
						
						System.out.println("Non può contenere un numero negativo!");
						
					}
				}
				
				
				System.out.println("Vuoi disdire delle prenotazioni? (si/no): ");
				risposta = in.nextLine();
				
				if (risposta.equals("si")) {
					
					System.out.println("Quanti posti vuoi disdire? ");
					String strNumeroDisdette = in.nextLine();
					int numeroDisdette = Integer.valueOf(strNumeroDisdette);
					
					if (numeroDisdette > 0) {
						
						for (int i = 0; i < numeroDisdette; i++) {
							
							evento.disdici();
							
						}
					}else {
						System.out.println("Non può contenere un numero negativo!");
					}
					
				}
				
				System.out.println(evento);
				
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
			System.out.println("Vuoi aggiungere un nuovo evento? (si/no) ");
			String risposta = in.nextLine();
			
			if (risposta.equals("no")) {
				System.out.println("Vuoi cancellare tutto?");
				String cancella = in.nextLine();
				
				if (cancella.equals("si")) {
					p.svuotaEventi();	
					System.out.println("La lista "+ p.getTitolo() + " è stata svuotata");
					in.close();
					return ;
				}
				
				System.out.println("Vuoi filtrare la lista per una determinata data? (si/no) ");
				String filtroData = in.nextLine();
				
				if (filtroData.equals("si")) {
					
					System.out.println("Inserisci una data: ");
					String dataInserita = in.nextLine();
					LocalDate d = LocalDate.parse(dataInserita, DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
					System.out.println("\n" + p.visualizzaProgramma(p.getEventiFiltrati(d)));
					in.close();
					return;
				}
				
				break;
			}
			
		}
		
		in.close();
		
		System.out.println("\n" + p.visualizzaProgramma(p.getEventi()));
	}

}
