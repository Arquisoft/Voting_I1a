package es.uniovi.asw.voting;

import es.uniovi.asw.model.PoliticalParty;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.PoliticalPartyRepository;
import es.uniovi.asw.persistence.VoteRepository;
import es.uniovi.asw.persistence.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Voting {

    @Autowired private VoteRepository repository;
    @Autowired private VoterRepository voterRepository;
    @Autowired private PoliticalPartyRepository politicalPartyRepository;

    public Vote vote(String voterEmail, String voterPassword, long partyId) {
        Voter voter = voterRepository.findByEmail(voterEmail);

        if (voter == null) return null;
        if (!voter.getPassword().equals(voterPassword)) return null;
        if (voter.isHasVoted()) return null;

        PoliticalParty politicalParty = politicalPartyRepository.findOne(partyId);

        Vote vote = new Vote(politicalParty, voter.getPollingStationCode());
        repository.save(vote);

        voter.setHasVoted(true);
        voterRepository.save(voter);

        return vote;

    }

}
