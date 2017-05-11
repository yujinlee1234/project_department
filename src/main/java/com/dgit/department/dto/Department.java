package com.dgit.department.dto;

public class Department {
	/* FIELDS */
	private int dcode;
	private String dname;
	private int floor;
	/* GET/SET */
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	/* METHODS */
	@Override
	public String toString() {
		return String.format("%s(%s층)", dname, floor);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dcode;
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
		Department other = (Department) obj;
		if (dcode != other.dcode)
			return false;
		return true;
	}
	
	public String[] toArray(){
		return new String[]{"D"+String.format("%03d",dcode), dname, floor+""};
	}
}
