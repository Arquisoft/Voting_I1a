package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Vote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private PoliticalParty politicalParty;

    protected Vote() {}

    public Vote(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }
}
