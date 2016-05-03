package es.uniovi.asw.access;

import java.sql.SQLException;

import es.uniovi.asw.dbUpdate.Database;
import es.uniovi.asw.dbUpdate.verifiers.VoterVerifier;
import es.uniovi.asw.exceptions.ExceptionMessages;
import es.uniovi.asw.exceptions.InvalidParameterException;
import es.uniovi.asw.model.Voter;

/**
 * Class to access to the e-voter mode
 * Only for users allowed to vote online
 * 
 */
public class LogInEV {
	
	public Voter logIn(String nif, String password) throws SQLException, InvalidParameterException{
		
		Database database = new Database();
		
		Voter voter = database.findVoter(nif);
		
		VoterVerifier.check(voter);
		
		if(!voter.isEVoter()){
			throw new InvalidParameterException(ExceptionMessages.NOT_EVOTER);
		}
		
		if(!voter.getPassword().equals(password)){
			throw new InvalidParameterException(ExceptionMessages.WRONG_PASSWORD);
		}
		
		return voter;
	}
}
