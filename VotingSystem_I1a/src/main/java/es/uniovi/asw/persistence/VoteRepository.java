package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;
import es.uniovi.asw.model.Vote;

/**
 * Created by takit on 03/05/2016.
 */
public interface VoteRepository extends CrudRepository<Vote, Long> {

    void addVote(Vote vote);

}
