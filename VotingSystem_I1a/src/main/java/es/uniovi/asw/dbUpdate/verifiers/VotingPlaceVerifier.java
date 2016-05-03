package es.uniovi.asw.dbUpdate.verifiers;

import es.uniovi.asw.exceptions.ExceptionMessages;
import es.uniovi.asw.exceptions.InvalidParameterException;
import es.uniovi.asw.model.VotingPlace;

public class VotingPlaceVerifier {
	
	public void verify(VotingPlace votingPlace) throws InvalidParameterException{
		
		if(votingPlace == null){
			throw new InvalidParameterException(ExceptionMessages.WRONG_VOTING_PLACE);
		}
	}

}
