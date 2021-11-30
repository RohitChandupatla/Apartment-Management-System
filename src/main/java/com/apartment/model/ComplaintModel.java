package com.apartment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ComplaintModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHno() {
		return hno;
	}
	@Override
	public String toString() {
		return "ComplaintModel [id=" + id + ", hno=" + hno + ", username=" + username + ", complaint=" + complaint
				+ ", date=" + date + "]";
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String hno;
	private String username;
	private String complaint;
	private String date;
	
	
}
