package com.Employee.FinalProject;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Address")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empID;
	private String name;
	private String designation;
	private Date creationDate;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(int empID, String name, String designation, Date creationDate) {
		super();
		this.empID = empID;
		this.name = name;
		this.designation = designation;
		this.creationDate = creationDate;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return this.empID+" : "+this.name+" : "+this.designation;
	}
}
