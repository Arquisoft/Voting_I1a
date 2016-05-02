package es.uniovi.asw.parser.letters;

import com.itextpdf.text.DocumentException;
import es.uniovi.asw.models.Voter;

import java.io.FileNotFoundException;


/**
 * @author UO238754
 */
public interface LetterGenerator {

	/**
	 * Generates the letters to communicate the user that he has been added to the Electoral Roll
	 * The letter contain his login name and password.
	 * The login name will be the email.
	 * It receives the data from the user
	 * @throws FileNotFoundException
	 * @throws DocumentException 
	 */
	void generateLetter(Voter voter) throws FileNotFoundException, DocumentException;
	
}
