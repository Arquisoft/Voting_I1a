package es.uniovi.asw.parser;

import es.uniovi.asw.models.Voter;
import es.uniovi.asw.parser.letters.LetterGenerator;
import es.uniovi.asw.parser.letters.TxtLetter;
import es.uniovi.asw.parser.reader.ExcelReader;
import es.uniovi.asw.parser.reader.FileReader;
import es.uniovi.asw.persistence.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This is the core class of the Parser component. It receives the file from the
 * ArgumentsParser class, reads it to obtain all the voters, creates a password
 * for each one of them. Then uploads the voters and the passwords to the
 * database and generates a letter for them with the respective password and
 * email.
 * 
 * @author UO238739
 *
 */
@Component
public class CensusParser {

	@Autowired
	private VoterRepository voterRepository;

	private FileReader reader;
	private LetterGenerator letterGenerator;

	public CensusParser(FileReader reader, LetterGenerator letterGenerator) {
		this.reader = reader;
		this.letterGenerator = letterGenerator;
	}

	public CensusParser() {
		this(new ExcelReader(), new TxtLetter());
	}

	public CensusParser(FileReader reader) {
		this(reader, new TxtLetter());
	}

	public void process(String file) {
		List<Voter> voters;

		try {
			// obtain voters from file
			voters = reader.read(file);

			// create passwords for voters
			for (Voter voter : voters) {
				voter.setPassword(PasswordGenerator.generateRandomPassword());
			}

			// upload voters to the DB
			voterRepository.save(voters);

			// create letters
			for (Voter voter : voters) {
				letterGenerator.generateLetter(voter);
			}
		} catch (Exception e) {
			//TODO exception handling
			System.err.println("Exception handling not yet implemented");
		}
	}
	
}
