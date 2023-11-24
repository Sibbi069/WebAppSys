package edu.fra.uas.notendurchschnitt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
  
@Component
public class Note {

    private static final Logger log = LoggerFactory.getLogger(Note.class);

    private double wert;
    private String fach;

    @PostConstruct
    public void postConstruct() {
		wert = 1;
        fach = "n/a";
        log.info("Test");
    }

    public Note(){
        
    }

    public double getWert() {
        return wert;
    }
    public void setWert(double wert) {
        this.wert = wert;
    }
    public String getFach() {
        return fach;
    }
    public void setFach(String fach) {
        this.fach = fach;
    }
    public String toString(){
        return "" + fach + " " + wert;
    }

    @PreDestroy
    public void preDestroy() {
		log.info("preDestroy() --> ");
	}

    
}
