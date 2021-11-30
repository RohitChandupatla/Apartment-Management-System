package com.apartment.model; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExpensesModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private float parking;
	private float cleaning;
	private float salary;
	private float eventcost;
	private String event;
	private String hno;

	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getParking() {
		return parking;
	}
	public void setParking(float parking) {
		this.parking = parking;
	}
	public float getCleaning() {
		return cleaning;
	}
	public void setCleaning(float cleaning) {
		this.cleaning = cleaning;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getEventcost() {
		return eventcost;
	}
	public void setEventcost(float eventcost) {
		this.eventcost = eventcost;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ExpensesModel [id=" + id + ", parking=" + parking + ", cleaning=" + cleaning + ", salary=" + salary
				+ ", eventcost=" + eventcost + ", event=" + event + ", hno=" + hno + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
	
}
