package es.uniovi.asw.dbUpdate.verifiers;

import main.java.es.uniovi.asw.exceptions.ExceptionMessages;
import main.java.es.uniovi.asw.exceptions.InvalidParameterException;
import main.java.es.uniovi.asw.model.Option;
import main.java.es.uniovi.asw.model.Vote;

public class VoteVerifier {

	public static void check(Vote vote) throws InvalidParameterException{
		
		if(vote.getOption()!=Option.Candidate1|| vote.getOption()!= Option.Candidate2
				||vote.getOption()!=Option.Candidate3 || vote.getOption()!=Option.Candidate4 
				|| vote.getOption()!=Option.nulo
				|| vote.getOption()!=Option.whiteVote){
			throw new InvalidParameterException(ExceptionMessages.NOT_ALLOWED_VOTE);
		}
	}
}
