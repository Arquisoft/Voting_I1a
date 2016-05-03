package es.uniovi.asw.results;

import es.uniovi.asw.model.VoteCount;
import es.uniovi.asw.persistence.VoteCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Results {

    @Autowired
    private VoteCountRepository voteCountRepository;

    public Iterable<VoteCount> results() {
        return voteCountRepository.findAll();
    }

}
