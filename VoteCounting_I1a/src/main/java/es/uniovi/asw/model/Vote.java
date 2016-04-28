package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String politicalParty;

    protected Vote() {}

    public Vote(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }
}
