package es.uniovi.asw.counting;

import es.uniovi.asw.model.PoliticalParty;
import es.uniovi.asw.model.VoteCount;
import es.uniovi.asw.persistence.VoteCountRepository;
import es.uniovi.asw.persistence.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteCounter {

    @Autowired private VoteRepository voteRepository;
    @Autowired  private VoteCountRepository voteCountRepository;

    public void count() {
        Iterable<VoteCount> counts = voteCountRepository.findAll();

        for (VoteCount count: counts) {
            PoliticalParty politicalParty = count.getPoliticalParty();

            int total = voteRepository.findByPoliticalParty(politicalParty).size();
            count.setTotalVotes(total);
            voteCountRepository.save(count);
        }
    }
}
