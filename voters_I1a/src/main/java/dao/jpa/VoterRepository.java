package dao.jpa;

import model.Voter;
import org.springframework.data.repository.CrudRepository;

public interface VoterRepository extends CrudRepository<Voter, Long> {

    Voter findByEmail(String email);

}
