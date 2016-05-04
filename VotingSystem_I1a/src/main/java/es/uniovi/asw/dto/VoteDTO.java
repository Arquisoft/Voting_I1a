package es.uniovi.asw.dto;

import java.io.Serializable;

public class VoteDTO implements Serializable {

    private String voterEmail;
    private String voterPassword;
    private long politicalPartyId;

    public VoteDTO() {}

    public VoteDTO(String voterEmail, String voterPassword, long politicalPartyId) {
        this.voterEmail = voterEmail;
        this.voterPassword = voterPassword;
        this.politicalPartyId = politicalPartyId;
    }

    public String getVoterEmail() {
        return voterEmail;
    }

    public void setVoterEmail(String voterEmail) {
        this.voterEmail = voterEmail;
    }

    public String getVoterPassword() {
        return voterPassword;
    }

    public void setVoterPassword(String voterPassword) {
        this.voterPassword = voterPassword;
    }

    public long getPoliticalPartyId() {
        return politicalPartyId;
    }

    public void setPoliticalPartyId(long politicalPartyId) {
        this.politicalPartyId = politicalPartyId;
    }

}
