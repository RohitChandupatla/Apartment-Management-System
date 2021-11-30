package com.apartment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExpensesPaid {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 private String hno;
 private String expenseid;
 private String username;
 private String status;
@Override
public String toString() {
	return "ExpensesPaid [id=" + id + ", hno=" + hno + ", expenseid=" + expenseid + ", username=" + username
			+ ", status=" + status + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getHno() {
	return hno;
}
public void setHno(String hno) {
	this.hno = hno;
}
public String getExpenseid() {
	return expenseid;
}
public void setExpenseid(String expenseid) {
	this.expenseid = expenseid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
