package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vote {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	private Option option;

	private VotingPlace votingPlace;

	private String pollingStationCode;
	
	public Vote(Long id, Option option){
		this.id = id;
		this.option = option;
	}
	
	public Vote(Option option){
		this.option = option;
	}

	public Vote(Long id, Option option, String pollingStationCode) {
		this.id = id;
		this.option = option;
		this.pollingStationCode = pollingStationCode;
	}
	
	public Vote(Long id, Option option, VotingPlace votingPlace) {
		this.id = id;
		this.option = option;
		this.votingPlace = votingPlace;
	}

	public String getPollingStationCode() { return pollingStationCode; }

	public void setPollingStationCode(String pollingStationCode) {
		this.pollingStationCode = pollingStationCode;
	}

	public String getOptionS() {
		return option.toString();
	}
	
	public Option getOption(){
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public VotingPlace getVotingPlace() {
		return votingPlace;
	}

	public void setVotingPlace(VotingPlace votingPlace) {
		this.votingPlace = votingPlace;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((option == null) ? 0 : option.hashCode());
		result = prime * result
				+ ((votingPlace == null) ? 0 : votingPlace.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (option != other.option)
			return false;
		if (votingPlace == null) {
			if (other.votingPlace != null)
				return false;
		} else if (!votingPlace.equals(other.votingPlace))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", option=" + option
				+ ", votingPlace=" + votingPlace + "]";
	}
}
