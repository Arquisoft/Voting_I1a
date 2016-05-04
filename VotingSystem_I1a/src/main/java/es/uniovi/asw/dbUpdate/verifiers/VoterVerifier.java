package es.uniovi.asw.dbUpdate.verifiers;

import es.uniovi.asw.model.Voter;

public class VoterVerifier {
	
	public static boolean check(Voter voter){
		
		if(voter == null){
			return false;
		}

		else if(voter.getName() == null || voter.getName().equals("")){
			return false;
		}
		
		else if(voter.getNif() == null || voter.getNif().equals("")){
			return false;
		}
		else if(!voter.isHasVoted()) {
			return false;
		}

		return true;
	}
}
