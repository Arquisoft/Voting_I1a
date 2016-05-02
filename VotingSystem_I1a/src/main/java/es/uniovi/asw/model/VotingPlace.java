package es.uniovi.asw.model;

/**
 *
 */
public class VotingPlace {
	
	private Long id;
	
	private int code;
	private String pollingStation;
	
	public VotingPlace(Long id, int code, String pollingStation) {
		super();
		this.id = id;
		this.code = code;
		this.pollingStation = pollingStation;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getPollingStation() {
		return pollingStation;
	}

	public void setPollingStation(String pollingStation) {
		this.pollingStation = pollingStation;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((pollingStation == null) ? 0 : pollingStation.hashCode());
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
		VotingPlace other = (VotingPlace) obj;
		if (code != other.code)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pollingStation == null) {
			if (other.pollingStation != null)
				return false;
		} else if (!pollingStation.equals(other.pollingStation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VotingPlace [id=" + id + ", code=" + code + ", pollingStation="
				+ pollingStation + "]";
	}

}
