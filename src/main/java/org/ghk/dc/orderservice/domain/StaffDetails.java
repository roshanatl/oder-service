package org.ghk.dc.orderservice.domain;

public class StaffDetails {
	private String id;
	private String group;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "StaffDetails [id=" + id + ", group=" + group + ", name=" + name + "]";
	}
	
	

}
