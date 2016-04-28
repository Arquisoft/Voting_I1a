package es.uniovi.asw.results;

import es.uniovi.asw.model.VoteCount;
import es.uniovi.asw.persistence.VoteCountRepository;

public class Results {

    private VoteCountRepository voteCountRepository;

    public Results(VoteCountRepository voteCountRepository) {
        this.voteCountRepository = voteCountRepository;
    }

    public Iterable<VoteCount> results() {
        return voteCountRepository.findAll();
    }

}
