package es.uniovi.asw.parser.reader;

import es.uniovi.asw.models.Voter;

import java.io.IOException;
import java.util.List;

/**
 * Interface that every class processing an input file for the census info must implement
 * @author UO238739
 *
 */
public interface FileReader {

	List<Voter> read(String file) throws IOException;

}
