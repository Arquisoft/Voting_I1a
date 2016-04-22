package main.java.es.uniovi.asw.dbUpdate.verifiers;

import main.java.es.uniovi.asw.exceptions.ExceptionMessages;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;
import main.java.es.uniovi.asw.model.VotingPlace;

public class VotingPlaceVerifier {
	
	public void verify(VotingPlace votingPlace) throws InvalidParameterException{
		
		if(votingPlace == null){
			throw new InvalidParameterException(ExceptionMessages.WRONG_VOTING_PLACE);
		}
	}

}
