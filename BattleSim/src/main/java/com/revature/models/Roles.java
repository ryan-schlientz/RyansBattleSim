package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Roles {

	@Id
	@Column(name="r_id", updatable=false)
	@SequenceGenerator(sequenceName="role_id_maker", name="role_id_maker")
	@GeneratedValue(generator="role_id_maker", strategy=GenerationType.SEQUENCE)
	private int r_id;
	
	private String name;
	
	public Roles() {
		super();
	}

	public Roles(String name) {
		super();
		this.name = name;
	}

	public Roles(int r_id, String name) {
		super();
		this.r_id = r_id;
		this.name = name;
	}
	
	public int getR_id() {
		return r_id;
	}
	
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Roles [r_id=" + r_id + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + r_id;
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
		Roles other = (Roles) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (r_id != other.r_id)
			return false;
		return true;
	}
	
}
