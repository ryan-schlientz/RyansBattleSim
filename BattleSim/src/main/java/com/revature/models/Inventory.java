package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Inventory {

	@OneToOne
	@JoinColumn(name="i_id")
	private Item item;
	
	@OneToOne
	@JoinColumn(name="cr_id")
	private Creature cr;
	
	private int isEquipped;

	public Inventory() {
		super();
	}

	public Inventory(Item item, Creature cr, int isEquipped) {
		super();
		this.item = item;
		this.cr = cr;
		this.isEquipped = isEquipped;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cr == null) ? 0 : cr.hashCode());
		result = prime * result + isEquipped;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		Inventory other = (Inventory) obj;
		if (cr == null) {
			if (other.cr != null)
				return false;
		} else if (!cr.equals(other.cr))
			return false;
		if (isEquipped != other.isEquipped)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Creature getCr() {
		return cr;
	}

	public void setCr(Creature cr) {
		this.cr = cr;
	}

	public int getIsEquipped() {
		return isEquipped;
	}

	public void setIsEquipped(int isEquipped) {
		this.isEquipped = isEquipped;
	}

	@Override
	public String toString() {
		return "Inventory [item=" + item + ", cr=" + cr + ", isEquipped=" + isEquipped + "]";
	}
	
}
