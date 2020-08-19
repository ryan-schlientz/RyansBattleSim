package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class BattleClass {
	
	
	@Id
	@Column(name= "class_id", updatable= false)
	@SequenceGenerator(name="class_seq", sequenceName = "class_seq")
	@GeneratedValue(generator = "class_seq", strategy = GenerationType.SEQUENCE)
	private int classId;
	private String title;
	
	public BattleClass() {
		super();
	}

	public BattleClass(int classId, String title) {
		super();
		this.classId = classId;
		this.title = title;
	}

	public BattleClass(String title) {
		super();
		this.title = title;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		BattleClass other = (BattleClass) obj;
		if (classId != other.classId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "BattleClass [classId=" + classId + ", title=" + title + "]";
	}
	

}
