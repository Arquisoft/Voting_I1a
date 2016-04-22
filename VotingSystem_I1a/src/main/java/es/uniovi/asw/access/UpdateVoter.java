package main.java.es.uniovi.asw.access;

import java.sql.SQLException;

import main.java.es.uniovi.asw.dbUpdate.Database;
import main.java.es.uniovi.asw.dbUpdate.verifiers.VoterVerifier;
import main.java.es.uniovi.asw.exceptions.ExceptionMessages;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;
import main.java.es.uniovi.asw.model.Voter;

/**
 * Class that updates the voters that have alredy voted
 * (change the field hasVoted from false to true)
 */
public class UpdateVoter{
	
	public Voter updateVoter(String nif) throws InvalidParameterException, SQLException{
		
		Database database = new Database();
		
		Voter voter = database.findVoter(nif);
		
		VoterVerifier.check(voter);
		
		if(voter.isHasVoted()){
			throw new InvalidParameterException(ExceptionMessages.HAS_ALREADY_VOTED);
		}
		
		voter.setHasVoted(true);
		
		return database.updateHasVoted(voter);
	}

}
