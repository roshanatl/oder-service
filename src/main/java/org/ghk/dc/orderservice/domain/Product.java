package org.ghk.dc.orderservice.domain;

public class Product {
	private String id;
	private String catalog;
	private String quatity;
	private String price;
	private String name;
	private boolean isAutopost;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getQuatity() {
		return quatity;
	}
	public void setQuatity(String quatity) {
		this.quatity = quatity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public boolean isAutopost() {
		return isAutopost;
	}
	public void setAutopost(boolean isAutopost) {
		this.isAutopost = isAutopost;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
