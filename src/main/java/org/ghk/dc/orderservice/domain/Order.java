package org.ghk.dc.orderservice.domain;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

@SuppressWarnings("deprecation")
@JsonSerialize(include = Inclusion.NON_NULL)
public class Order {

	@Id
	public String id;
	public String itemName;
	public String price;
	public String status;
	public String staffDeatils;
	public String remarks;
	public String reminder;
	public Boolean isAutopost;

	@CreatedBy
	private String createUser;

	@CreatedDate
	private Date createdDate;

	@LastModifiedBy
	private String lastModifiedUser;

	@LastModifiedDate
	private Date updateDttm;

	public Order() {
	}

	public Order(String itemName, String price) {
		this.price = price;
		this.itemName = itemName;
		this.status = "Created";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public Date getUpdateDttm() {
		return updateDttm;
	}

	public void setUpdateDttm(Date updateDttm) {
		this.updateDttm = updateDttm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public Boolean getIsAutopost() {
		return isAutopost;
	}

	public void setIsAutopost(Boolean isAutopost) {
		this.isAutopost = isAutopost;
	}

	public String getStaffDeatils() {
		return staffDeatils;
	}

	public void setStaffDeatils(String staffDeatils) {
		this.staffDeatils = staffDeatils;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", itemName=" + itemName + ", price=" + price + ", status=" + status
				+ ", staffDeatils=" + staffDeatils + ", remarks=" + remarks + ", reminder=" + reminder + ", isAutopost="
				+ isAutopost + ", createUser=" + createUser + ", createdDate=" + createdDate + ", lastModifiedUser="
				+ lastModifiedUser + ", updateDttm=" + updateDttm + "]";
	}

}
