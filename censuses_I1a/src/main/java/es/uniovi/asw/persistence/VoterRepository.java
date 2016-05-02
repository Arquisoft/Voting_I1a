package es.uniovi.asw.persistence;

import es.uniovi.asw.models.Voter;
import org.springframework.data.repository.CrudRepository;

public interface VoterRepository extends CrudRepository<Voter, Long> {
}
