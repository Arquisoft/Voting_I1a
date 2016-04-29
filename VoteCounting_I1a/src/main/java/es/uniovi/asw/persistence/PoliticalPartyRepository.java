package es.uniovi.asw.persistence;

import es.uniovi.asw.model.PoliticalParty;
import org.springframework.data.repository.CrudRepository;

public interface PoliticalPartyRepository extends CrudRepository<PoliticalParty, Long> {

    PoliticalParty findByName(String name);

}
