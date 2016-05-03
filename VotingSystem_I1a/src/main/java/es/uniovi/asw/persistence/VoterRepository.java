package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;
import es.uniovi.asw.model.Voter;


/**
 * Created by takit on 03/05/2016.
 */
public interface VoterRepository extends CrudRepository<Voter, Long> {

    Voter findByNif(Long nif);

    void updateHasVoted(String nif);
}
