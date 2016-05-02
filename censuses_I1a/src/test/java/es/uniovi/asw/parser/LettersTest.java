package es.uniovi.asw.parser;

import com.itextpdf.text.DocumentException;
import es.uniovi.asw.models.Voter;
import es.uniovi.asw.parser.letters.LetterGenerator;
import es.uniovi.asw.parser.letters.PDFLetter;
import es.uniovi.asw.parser.letters.TxtLetter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

public class LettersTest {

	private Voter voter;

	@Before
	public void setUp(){
		voter = new Voter("Testín Téstez", "00000000T", 1, "test@email.com");
	}
	
	@Test
	public void testTxtLetter() throws FileNotFoundException, DocumentException {
		LetterGenerator generator = new TxtLetter();
		generator.generateLetter(voter);
		File newLetter = new File("letters/" + voter.getNif() + ".txt");
		assertTrue(newLetter.exists());
	}

}
