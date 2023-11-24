package edu.fra.uas.notendurchschnitt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
public class Schueler {

    @Autowired
    private Note note;

    private static final Logger log = LoggerFactory.getLogger(Schueler.class);

    private String nachname;
    private String vorname;
    private int matrNr;
    private List<Note> noten;
    private Scanner scan;
    private int anzahl;
    private String notenTabelle ="";
    private double zwWert;
    private double noteWert;
    
    @PostConstruct
    public void postConstruct() {
        nachname = "";
        vorname = "";
        matrNr = 0;
        noten = new ArrayList<>();
        scan = new Scanner(System.in);
        log.info("PostConstruct--> " );
	}

    public Schueler(){
    }
    private double durschschnitt;
    
    

    public List<Note> getNoten() {
        return noten;
    }
    public void setNoten(List<Note> noten) {
        this.noten = noten;
    }
    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public int getMatrNr() {
        return matrNr;
    }
    public void setMatrNr(int matrNr) {
        this.matrNr = matrNr;
    }
    public double durschschnitt(List<Note> noten){

        Scanner input = new Scanner(System.in);

        System.out.println("Bitte Nachname eingeben: ");
		nachname = input.nextLine();

		System.out.println("Bitte Vornamen eingeben: ");
		vorname = input.nextLine();

		System.out.println("Bitte Matrikelnummer eingeben: ");
		matrNr = input.nextInt();
        input.nextLine();

				
        
        System.out.println("Bitte Anzahl der Noten angeben: ");
        anzahl = input.nextInt();
        input.nextLine();

        for(int i = 0;i<anzahl;i++){

            System.out.println("Bitte Fach angeben: ");
            note.setFach(scan.nextLine());

            System.out.println("Bitte Notenwert angeben: ");
            note.setWert(scan.nextDouble());;
            scan.nextLine();

            noten.add(note);
        }
        input.close();

        for(int i = 0;i<noten.size();i++){
            noteWert = noteWert + noten.get(i).getWert();
        }

    zwWert = noteWert/noten.size();
    durschschnitt = Math.round(zwWert * 100.0)/100.0;

    scan.close();

    return durschschnitt;
    }

  
    public String toString(){
        for (Note note : noten) {
            notenTabelle = notenTabelle + "[Fach: " + note.getFach() + " | Note: " + note.getWert() + " ]\n";
        }
        
        return nachname + " " + vorname + "\n" + matrNr +"\n" + notenTabelle + "[Durchschnitt: " + durschschnitt + " ]";
    }


    @PreDestroy
    public void preDestroy() {
		log.info("preDestroy() --> ");
	}

    

    

    
   
}

   
