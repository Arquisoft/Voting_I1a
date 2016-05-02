package es.uniovi.asw.exceptions;


/**
 * 
 * Class containing different messages according with the different errors. 
 * 
 */
public class ExceptionMessages {
	
	public static final String VOTER_DOES_NOT_EXIST ="This voter does not exist";
	
	public static final String VOTER_MUST_HAVE_NAME = "There cannot be a voter without name.";
	
	public static final String NIF_COMPULSORY = "Every voter must have nif.";
	
	public static final String NOT_ALLOWED_VOTE ="This vote is not allowed.";
	
	public static final String WRONG_VOTING_PLACE = "This voting place does not exist.";
	
	public static final String WRONG_PASSWORD = "The password is not correct.";
	
	public static final String EVOTER_NOT_ALLOWED = "You are not registered as e-voter.";
	
	public static final String ALREADY_EVOTER = "The voter is already e-voter.";
	
	public static final String NOT_EVOTER = "You are not an e-voter.";
	
	public final static String HAS_ALREADY_VOTED = "This voter has already voted.";
}
