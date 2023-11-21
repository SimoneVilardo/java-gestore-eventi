package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.lessons.java.pojo.Evento;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		

		System.out.println("Titolo Evento: ");
		String titolo = in.nextLine();
		
		System.out.print("Data (formato dd/MM/yyyy): ");
		String dataString = in.nextLine();
		LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println("Numero di posti totali disponibili: ");
		String strPostiTotali = in.nextLine();
		int postiTotali = Integer.valueOf(strPostiTotali);
		
		
		Evento evento = null;
		
		try {
			
			evento = new Evento(titolo, data, postiTotali);
			
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
			
			in.close();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
