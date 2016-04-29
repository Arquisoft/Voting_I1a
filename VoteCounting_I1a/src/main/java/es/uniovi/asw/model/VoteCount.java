package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class VoteCount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private PoliticalParty politicalParty;

    private long totalVotes;

    protected VoteCount() {}

    public VoteCount(PoliticalParty politicalParty) {
        this.politicalParty = politicalParty;
        this.totalVotes = 0L;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public long getTotalVotes() {
        return totalVotes;
    }

}
