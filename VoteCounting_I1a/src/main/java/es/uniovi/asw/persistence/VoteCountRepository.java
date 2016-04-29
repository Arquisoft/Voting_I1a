package es.uniovi.asw.persistence;

import es.uniovi.asw.model.VoteCount;
import org.springframework.data.repository.CrudRepository;

public interface VoteCountRepository extends CrudRepository<VoteCount, Long> {
}
