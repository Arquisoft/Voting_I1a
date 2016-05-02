package es.uniovi.asw;

import es.uniovi.asw.parser.ReadCensus;
import es.uniovi.asw.parser.reader.FileReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CensusesI1aApplication {

	public static void main(String[] args) {
		SpringApplication.run(CensusesI1aApplication.class, args);
	}

	@Bean
    public CommandLineRunner run(ReadCensus readCensus) {
        return readCensus::read;
    }

}
