package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id
	@Column(name = "i_id", updatable = false)
	@SequenceGenerator(name = "item_seq", sequenceName = "item_seq")
	@GeneratedValue(generator = "item_seq", strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	@Column(name = "ITEM_TYPE")
	private String itemtype;
	@Column(name = "STATS_ID")
	private int statsid;
	public Item() {
		super();
	}
	public Item(String name, String itemtype, int statsid) {
		super();
		this.name = name;
		this.itemtype = itemtype;
		this.statsid = statsid;
	}
	public Item(int id, String name, String itemtype, int statsid) {
		super();
		this.id = id;
		this.name = name;
		this.itemtype = itemtype;
		this.statsid = statsid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	public int getStatsid() {
		return statsid;
	}
	public void setStatsid(int statsid) {
		this.statsid = statsid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((itemtype == null) ? 0 : itemtype.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + statsid;
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
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		if (itemtype == null) {
			if (other.itemtype != null)
				return false;
		} else if (!itemtype.equals(other.itemtype))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (statsid != other.statsid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", itemtype=" + itemtype + ", statsid=" + statsid + "]";
	}
	
	
	

}
