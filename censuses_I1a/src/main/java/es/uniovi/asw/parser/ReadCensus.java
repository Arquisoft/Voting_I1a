package es.uniovi.asw.parser;

import org.springframework.stereotype.Component;

/**
 * Interface that must be implemented in order to read the file containing the census info
 * @author UO238739
 *
 */
@Component
public interface ReadCensus {

	void read(String[] args);
	
}
