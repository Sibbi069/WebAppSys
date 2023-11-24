package edu.fra.uas.notendurchschnitt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotendurchschnittApplication {

	@Autowired
	private Schueler schueler;

	
	public static void main(String[] args) {
		SpringApplication.run(NotendurchschnittApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(){
		CommandLineRunner action = new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception{

				schueler.durschschnitt(schueler.getNoten());
				System.out.println(schueler);
			}
		};
		return action;
		
	}
	
}
