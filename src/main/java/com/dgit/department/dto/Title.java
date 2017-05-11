package com.dgit.department.dto;

public class Title {
	/* FILEDS */
	private int tcode;
	private String tname;
	/* GET/SET */
	public int getTcode() {
		return tcode;
	}
	public void setTcode(int tcode) {
		this.tcode = tcode;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	/* METHODS */
	@Override
	public String toString() {
		return String.format("%s", tname);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tcode;
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
		Title other = (Title) obj;
		if (tcode != other.tcode)
			return false;
		return true;
	}
	
	public String[] toArray(){
		return new String[]{"T"+String.format("%03d",tcode), tname};
	}
}
