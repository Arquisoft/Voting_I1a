package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;
import es.uniovi.asw.model.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {

}
