package com.apartment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MemberModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String sid;
	private String name;
	private String email;
	private String mobile;
	private String hno;
	private String sqareyards;
	private String hdescription;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getSqareyards() {
		return sqareyards;
	}
	public void setSqareyards(String sqareyards) {
		this.sqareyards = sqareyards;
	}
	public String getHdescription() {
		return hdescription;
	}
	public void setHdescription(String hdescription) {
		this.hdescription = hdescription;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MemberModel [id=" + id + ", sid=" + sid + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", hno=" + hno + ", sqareyards=" + sqareyards + ", hdescription=" + hdescription + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
	
	
}
