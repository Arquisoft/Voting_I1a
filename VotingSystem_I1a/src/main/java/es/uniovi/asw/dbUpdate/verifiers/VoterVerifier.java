package main.java.es.uniovi.asw.dbUpdate.verifiers;

import main.java.es.uniovi.asw.exceptions.ExceptionMessages;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;
import main.java.es.uniovi.asw.model.Voter;

public class VoterVerifier {
	
	public static void check(Voter voter) throws InvalidParameterException{
		
		if(voter == null){
			throw new InvalidParameterException(ExceptionMessages.VOTER_DOES_NOT_EXIST);
		}

		if(voter.getName() == null || voter.getName().equals("")){
			throw new InvalidParameterException(ExceptionMessages.VOTER_MUST_HAVE_NAME);
		}
		
		if(voter.getNif() == null || voter.getNif().equals("")){
			throw new InvalidParameterException(ExceptionMessages.NIF_COMPULSORY);
		}
	}
}
