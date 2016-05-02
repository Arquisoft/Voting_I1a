package es.uniovi.asw.model;

import java.util.Date;

public class Elections {
	
	private Long id;
	private Date starts;
	private Date ends;
	private String options;
	
	public Elections(Long id, Date starts, Date ends, String options) {
		this.id = id;
		this.starts = starts;
		this.ends = ends;
		this.options = options;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStarts() {
		return starts;
	}

	public void setStarts(Date starts) {
		this.starts = starts;
	}

	public Date getEnds() {
		return ends;
	}

	public void setEnds(Date ends) {
		this.ends = ends;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ends == null) ? 0 : ends.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + ((starts == null) ? 0 : starts.hashCode());
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
		Elections other = (Elections) obj;
		if (ends == null) {
			if (other.ends != null)
				return false;
		} else if (!ends.equals(other.ends))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (starts == null) {
			if (other.starts != null)
				return false;
		} else if (!starts.equals(other.starts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Elections [id=" + id + ", starts=" + starts + ", ends=" + ends
				+ ", options=" + options + "]";
	}

}
