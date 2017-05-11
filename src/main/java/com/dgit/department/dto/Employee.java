package com.dgit.department.dto;

import java.util.Date;

public class Employee {
	/* FIELDS */
	private int eno;
	private String ename;
	private int salary;
	private Department dno;
	private boolean gender;
	private Date joindate;
	private Title title;
	/* GET/SET */
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDno() {
		return dno;
	}
	public void setDno(Department dno) {
		this.dno = dno;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	/* METHODS */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eno;
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
		Employee other = (Employee) obj;
		if (eno != other.eno)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format("Employee [eno=%s, ename=%s, salary=%s, dno=%s, gender=%s, joindate=%s, title=%s]", eno,
				ename, salary, dno, gender, joindate, title);
	}	
}
