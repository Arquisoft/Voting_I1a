package es.uniovi.asw.dbUpdate.verifiers;

import es.uniovi.asw.exceptions.ExceptionMessages;
import es.uniovi.asw.exceptions.InvalidParameterException;
import es.uniovi.asw.model.Option;
import es.uniovi.asw.model.Vote;

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
