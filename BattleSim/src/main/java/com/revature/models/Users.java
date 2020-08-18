package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/*
 * CREATE TABLE users (
    id NUMBER(10) PRIMARY KEY,
    username VARCHAR2(50) UNIQUE,
    password VARCHAR2(75),
    r_id NUMBER(10));
    
*/

@Entity
public class Users {
	@Id
	@Column(name="id", updatable=false)
	@SequenceGenerator(sequenceName="user_id_maker", name="user_id_maker")
	@GeneratedValue(generator="user_id_maker", strategy=GenerationType.SEQUENCE)
	private int id;

	private String username;
	private String password;
	
	@ManyToOne()
	@JoinColumn(name="r_id")
	private int r_id;
	
	public Users() {
		super();
	}

	public Users(int id, String username, String password, int r_id) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.r_id = r_id;
	}

	public Users(String username, String password, int r_id) {
		super();
		this.username = username;
		this.password = password;
		this.r_id = r_id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + r_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Users other = (Users) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (r_id != other.r_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", r_id=" + r_id + "]";
	}

}
