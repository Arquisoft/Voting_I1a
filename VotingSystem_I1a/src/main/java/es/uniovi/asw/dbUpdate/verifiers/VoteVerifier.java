package es.uniovi.asw.dbUpdate.verifiers;

import es.uniovi.asw.model.Option;
import es.uniovi.asw.model.Vote;

public class VoteVerifier {

	public static boolean check(Vote vote) {

		for(Option val : Option.values())
		{
			if(vote.getOption().equals(val))
			{
				return true;
			}
		}

		return false;
	}
}
