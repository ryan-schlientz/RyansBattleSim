package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Creature {
	
	@Id
	@Column(name= "cr_id", updatable= false)
	@SequenceGenerator(name="creature_seq", sequenceName = "creature_seq")
	@GeneratedValue(generator = "creature_seq", strategy = GenerationType.SEQUENCE)
	private int crId;
	private String name;
	@OneToOne
	@JoinColumn(name="s_id")
	private Stats stats;
	@ManyToOne
	@JoinColumn(name="class_id")
	private BattleClass battleClass;
	
	
	private float xpBase;


	public Creature() {
		super();
	}


	public Creature(int crId, String name, Stats stats, BattleClass battleClass, float xpBase) {
		super();
		this.crId = crId;
		this.name = name;
		this.stats = stats;
		this.battleClass = battleClass;
		this.xpBase = xpBase;
	}


	public Creature(String name, Stats stats, BattleClass battleClass, float xpBase) {
		super();
		this.name = name;
		this.stats = stats;
		this.battleClass = battleClass;
		this.xpBase = xpBase;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((battleClass == null) ? 0 : battleClass.hashCode());
		result = prime * result + crId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
		result = prime * result + Float.floatToIntBits(xpBase);
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
		Creature other = (Creature) obj;
		if (battleClass == null) {
			if (other.battleClass != null)
				return false;
		} else if (!battleClass.equals(other.battleClass))
			return false;
		if (crId != other.crId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		if (Float.floatToIntBits(xpBase) != Float.floatToIntBits(other.xpBase))
			return false;
		return true;
	}


	public int getCrId() {
		return crId;
	}


	public void setCrId(int crId) {
		this.crId = crId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Stats getStats() {
		return stats;
	}


	public void setStats(Stats stats) {
		this.stats = stats;
	}


	public BattleClass getBattleClass() {
		return battleClass;
	}


	public void setBattleClass(BattleClass battleClass) {
		this.battleClass = battleClass;
	}


	public double getXpBase() {
		return xpBase;
	}


	public void setXpBase(float xpBase) {
		this.xpBase = xpBase;
	}


	@Override
	public String toString() {
		return "Creature [crId=" + crId + ", name=" + name + ", stats=" + stats + ", battleClass=" + battleClass
				+ ", xpBase=" + xpBase + "]";
	}
	
	

}
