package model;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;

/**
 * Represents a voter
 */
@Entity
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nif;
    private String email;
    private String name;
    private String password;
    private int pollingStationCode;

    public Voter() {}

    public Voter(long id, String nif, String name, String email, String password, int pollingStationCode) {
        this.id = id;
        this.nif = nif;
        this.email = email;
        this.name = name;
        this.password = password;
        this.pollingStationCode = pollingStationCode;
    }

    /**
     * Check that a password matches the user's
     * @param password Password to be checked
     * @return True when it does. False otherwise
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPollingStationCode() {
        return pollingStationCode;
    }

    public long getId() {
        return id;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPollingStationCode(int pollingStationCode) {
        this.pollingStationCode = pollingStationCode;
    }
    
    
	@Override
	public String toString() {
		return "Voter [nif=" + nif + ", email=" + email + ", name=" + name
				+ ", password=" + password + ", pollingStationCode="
				+ pollingStationCode + "]";
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voter voter = (Voter) o;

        if (id != voter.id) return false;
        if (pollingStationCode != voter.pollingStationCode) return false;
        if (nif != null ? !nif.equals(voter.nif) : voter.nif != null) return false;
        if (email != null ? !email.equals(voter.email) : voter.email != null) return false;
        if (name != null ? !name.equals(voter.name) : voter.name != null) return false;
        return password != null ? password.equals(voter.password) : voter.password == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + pollingStationCode;
        return result;
    }
}