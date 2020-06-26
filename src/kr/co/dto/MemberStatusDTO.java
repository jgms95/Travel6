package kr.co.dto;
import java.io.Serializable;

public class MemberStatusDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String status;
	private String meaning;
	public MemberStatusDTO() {
		// TODO Auto-generated constructor stub
	}
	public MemberStatusDTO(String status, String meaning) {
		super();
		this.status = status;
		this.meaning = meaning;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		MemberStatusDTO other = (MemberStatusDTO) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	

}
