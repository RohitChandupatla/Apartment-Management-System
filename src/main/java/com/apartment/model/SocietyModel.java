package com.apartment.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SocietyModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String sid;
	private String societyname;
	private String societyhouses;
	private String societyaddress;
	private String societycity;
	private String societypincode;
	private String housetype;
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
	public String getSocietyname() {
		return societyname;
	}
	public void setSocietyname(String societyname) {
		this.societyname = societyname;
	}
	public String getSocietyhouses() {
		return societyhouses;
	}
	public void setSocietyhouses(String societyhouses) {
		this.societyhouses = societyhouses;
	}
	public String getSocietyaddress() {
		return societyaddress;
	}
	public void setSocietyaddress(String societyaddress) {
		this.societyaddress = societyaddress;
	}
	public String getSocietycity() {
		return societycity;
	}
	public void setSocietycity(String societycity) {
		this.societycity = societycity;
	}
	public String getSocietypincode() {
		return societypincode;
	}
	public void setSocietypincode(String societypincode) {
		this.societypincode = societypincode;
	}
	public String getHousetype() {
		return housetype;
	}
	public void setHousetype(String housetype) {
		this.housetype = housetype;
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
		return "SocietyModel [id=" + id + ", sid=" + sid + ", societyname=" + societyname + ", societyhouses="
				+ societyhouses + ", societyaddress=" + societyaddress + ", societycity=" + societycity
				+ ", societypincode=" + societypincode + ", housetype=" + housetype + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
	
	
	
}
