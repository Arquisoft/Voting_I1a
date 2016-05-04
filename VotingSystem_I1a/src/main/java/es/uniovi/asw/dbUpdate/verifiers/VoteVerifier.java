package es.uniovi.asw.dbUpdate.verifiers;

import es.uniovi.asw.model.Option;
import es.uniovi.asw.model.Vote;

public class VoteVerifier {

	public static boolean check(String vote) {

		for(Option val : Option.values())
		{
			if(vote.equals(val.toString()))
			{
				return true;
			}
		}

		return false;
	}
}
