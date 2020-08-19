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
public class Character {
	
	@Id
	@Column(name="c_id")
	@SequenceGenerator(name="character_seq", sequenceName = "character_seq")
	@GeneratedValue(generator = "character_seq", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="u_id")
	private Users user;
	@OneToOne
	@JoinColumn(name="cr_id")
	private Creature creature;
	public Character(int id, Users user, Creature creature) {
		super();
		this.id = id;
		this.user = user;
		this.creature = creature;
	}
	public Character(Users user, Creature creature) {
		super();
		this.user = user;
		this.creature = creature;
	}
	public Character() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creature == null) ? 0 : creature.hashCode());
		result = prime * result + id;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Character other = (Character) obj;
		if (creature == null) {
			if (other.creature != null)
				return false;
		} else if (!creature.equals(other.creature))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Creature getCreature() {
		return creature;
	}
	public void setCreature(Creature creature) {
		this.creature = creature;
	}
	@Override
	public String toString() {
		return "Character [id=" + id + ", user=" + user + ", creature=" + creature + "]";
	}
	
	
	
	

}
