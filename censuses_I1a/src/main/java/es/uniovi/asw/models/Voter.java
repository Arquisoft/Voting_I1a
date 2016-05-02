package es.uniovi.asw.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nif;
    private String email;
    private String name;
    private int pollingStationCode;
    private String password;

    public Voter() {}

    public Voter(String name, String nif, int pollingStationCode, String email) {
        this.name = name;
        this.nif = nif;
        this.pollingStationCode = pollingStationCode;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPollingStationCode() {
        return pollingStationCode;
    }

    public void setPollingStationCode(int pollingStationCode) {
        this.pollingStationCode = pollingStationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
