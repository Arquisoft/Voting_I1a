package es.uniovi.asw.access;

import java.sql.SQLException;

import es.uniovi.asw.dbUpdate.Database;
import es.uniovi.asw.dbUpdate.verifiers.VoteVerifier;
import es.uniovi.asw.dbUpdate.verifiers.VoterVerifier;
import es.uniovi.asw.exceptions.InvalidParameterException;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.Voter;

/**
 * Class that allows to vote
 * To do that, it inserts the vote, changes the field hasVoted to true and update the voter
 *
 */
public class VoteAction {
	
	public void vote(Vote vote, Voter voter) {

		try {
			Database database = new Database();

			if(VoterVerifier.check(voter))
			{
				voter.setHasVoted(true);
				database.updateHasVoted(voter);
			}

			if(VoteVerifier.check(vote))
			{
				database.insertVote(vote);
			}

		} catch (SQLException e)
		{
			// SQL ERROR
		} catch (InvalidParameterException ep) {
			//Parameter ERROR
		}
		
	}

}
