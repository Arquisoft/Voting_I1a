package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VoteCount {

    @Id
    private String politicalParty;

    private long totalVotes;

    protected VoteCount() {}

    public VoteCount(String politicalParty) {
        this.politicalParty = politicalParty;
        this.totalVotes = 0L;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public long getTotalVotes() {
        return totalVotes;
    }

}
