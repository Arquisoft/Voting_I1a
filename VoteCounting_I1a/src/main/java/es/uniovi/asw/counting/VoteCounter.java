package es.uniovi.asw.counting;

import es.uniovi.asw.model.VoteCount;
import es.uniovi.asw.persistence.VoteCountRepository;
import es.uniovi.asw.persistence.VoteRepository;

public class VoteCounter {

    private VoteRepository voteRepository;
    private VoteCountRepository voteCountRepository;

    public VoteCounter(VoteRepository voteRepository, VoteCountRepository voteCountRepository) {
        this.voteRepository = voteRepository;
        this.voteCountRepository = voteCountRepository;
    }

    public void count() {
        Iterable<VoteCount> counts = voteCountRepository.findAll();

        for (VoteCount count: counts) {
            String politicalParty = count.getPoliticalParty();

            int total = voteRepository.findByPoliticalParty(politicalParty).size();
            count.setTotalVotes(total);
            voteCountRepository.save(count);
        }
    }
}
