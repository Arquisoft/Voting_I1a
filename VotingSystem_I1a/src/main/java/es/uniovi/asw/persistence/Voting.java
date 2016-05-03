package es.uniovi.asw.persistence;

import es.uniovi.asw.dbUpdate.verifiers.VoteVerifier;
import es.uniovi.asw.dbUpdate.verifiers.VoterVerifier;
import es.uniovi.asw.model.Option;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by takit on 03/05/2016.
 */
@Component
public class Voting {

    @Autowired
    private VoteRepository repository;

    @Autowired
    private VoterRepository voterRepository;

    public void vote(Vote vote, Voter voter ) {
        repository.addVote(vote);

        if(VoterVerifier.check(voter)) {
            voter.setHasVoted(true);
            voterRepository.updateHasVoted(voter.getNif());

            if (VoteVerifier.check(vote)) {
                repository.addVote(vote);
            } else {
                vote.setOption(Option.whiteVote);
                repository.addVote(vote);
            }
        }
            //cant vote

    }

}
