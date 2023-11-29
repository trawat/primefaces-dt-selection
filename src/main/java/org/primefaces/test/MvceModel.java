package org.primefaces.test;

import java.util.Objects;

public class MvceModel {
	private Integer id;
	private String status;
	private String type;
	
	public MvceModel() {
		//nothing
	}
	
	public MvceModel(Integer id, String status, String type) {
		super();
		this.id = id;
		this.status = status;
		this.type = type;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MvceModel)) {
			return false;
		}
		MvceModel other = (MvceModel) obj;
		return Objects.equals(id, other.id);
	}
	
	
}