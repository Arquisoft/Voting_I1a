package es.uniovi.asw.model;

import javax.persistence.*;

@Entity
public class Vote {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private PoliticalParty politicalParty;
	private int pollingStationCode;

	public Vote() {}

	public Vote(PoliticalParty politicalParty, int pollingStationCode){
		this.politicalParty = politicalParty;
		this.pollingStationCode = pollingStationCode;
	}

	public int getPollingStationCode() { return pollingStationCode; }

	public void setPollingStationCode(int pollingStationCode) { this.pollingStationCode = pollingStationCode; }

    public PoliticalParty getPoliticalParty;

	public Long getId() {
		return id;
	}


}
