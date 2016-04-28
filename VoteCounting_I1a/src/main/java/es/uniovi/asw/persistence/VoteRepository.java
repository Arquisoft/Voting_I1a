package es.uniovi.asw.persistence;


import es.uniovi.asw.model.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    List<Vote> findByPoliticalParty(String politicalParty);

}
