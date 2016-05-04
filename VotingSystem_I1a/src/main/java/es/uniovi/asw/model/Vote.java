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

	private int pollingStationCode;

	public Vote()
	{

	}

	public Vote(Long id, Option option){
		this.id = id;
		this.option = option;
	}

	public Vote(Option option){
		this.option = option;
	}

	public Vote(Long id, Option option, int pollingStationCode) {
		this.id = id;
		this.option = option;
		this.pollingStationCode = pollingStationCode;
	}

	public int getPollingStationCode() { return pollingStationCode; }

	public void setPollingStationCode(int pollingStationCode) { this.pollingStationCode = pollingStationCode; }
	
	public Option getOption(){
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
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
		return true;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", option=" + option
				+ "]";
	}
}
