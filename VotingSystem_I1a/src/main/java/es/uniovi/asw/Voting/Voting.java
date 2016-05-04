package es.uniovi.asw.Voting;

import es.uniovi.asw.dbUpdate.verifiers.VoteVerifier;
import es.uniovi.asw.dbUpdate.verifiers.VoterVerifier;
import es.uniovi.asw.model.Option;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.VoteRepository;
import es.uniovi.asw.persistence.VoterRepository;
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

    public Vote vote(String party, Long id ) {
        Vote vote = null;
        Voter updatedVoter = voterRepository.findOne(id);

        if(VoterVerifier.check(updatedVoter)) {

            vote = new Vote();

            if (VoteVerifier.check(party)) {
                vote.setPollingStationCode(updatedVoter.getPollingStationCode());
                vote.setOption(Option.valueOf(party));
                repository.save(vote);

                updatedVoter.setHasVoted(true);
                voterRepository.save(updatedVoter);
            }
        }

        return vote;

    }

}
