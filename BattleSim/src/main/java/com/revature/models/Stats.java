package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Stats {
	
	@Id
	@Column(name = "s_id", updatable = false)
	@SequenceGenerator(name = "stats_seq", sequenceName = "stats_seq")
	@GeneratedValue(generator = "stats_seq", strategy = GenerationType.SEQUENCE)
	private int id;

	private int currentHealth;
	private int maxHP;
	private int attack;
	private int defense;
	private long xp;
	private long gold;
	
	public Stats() {
		super();
	}

	public Stats(int id, int currentHealth, int maxHP, int attack, int defense, long xp, long gold) {
		super();
		this.id = id;
		this.currentHealth = currentHealth;
		this.maxHP = maxHP;
		this.attack = attack;
		this.defense = defense;
		this.xp = xp;
		this.gold = gold;
	}

	public Stats(int currentHealth, int maxHP, int attack, int defense, long xp, long gold) {
		super();
		this.currentHealth = currentHealth;
		this.maxHP = maxHP;
		this.attack = attack;
		this.defense = defense;
		this.xp = xp;
		this.gold = gold;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attack;
		result = prime * result + currentHealth;
		result = prime * result + defense;
		result = prime * result + (int) (gold ^ (gold >>> 32));
		result = prime * result + id;
		result = prime * result + maxHP;
		result = prime * result + (int) (xp ^ (xp >>> 32));
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
		Stats other = (Stats) obj;
		if (attack != other.attack)
			return false;
		if (currentHealth != other.currentHealth)
			return false;
		if (defense != other.defense)
			return false;
		if (gold != other.gold)
			return false;
		if (id != other.id)
			return false;
		if (maxHP != other.maxHP)
			return false;
		if (xp != other.xp)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public long getXp() {
		return xp;
	}

	public void setXp(long xp) {
		this.xp = xp;
	}

	public long getGold() {
		return gold;
	}

	public void setGold(long gold) {
		this.gold = gold;
	}

	@Override
	public String toString() {
		return "Stats [id=" + id + ", currentHealth=" + currentHealth + ", maxHP=" + maxHP + ", attack=" + attack
				+ ", defense=" + defense + ", xp=" + xp + ", gold=" + gold + "]";
	}
	
}
