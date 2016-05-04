package es.uniovi.asw.dto;

import java.io.Serializable;

public class PoliticalPartyDTO implements Serializable {

    private String name;

    public PoliticalPartyDTO() {}

    public PoliticalPartyDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
