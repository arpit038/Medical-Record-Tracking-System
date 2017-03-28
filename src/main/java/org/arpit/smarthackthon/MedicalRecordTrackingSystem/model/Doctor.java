package org.arpit.smarthackthon.MedicalRecordTrackingSystem.model;

public class Doctor{

	private int id;
	private String name;
	private String dept;
	private int phone;
	private int yearsOfExp;
	private int hospitalId;
	private String Details;
	
	public Doctor(){

	}
	public Doctor(int id, String name, String dept, int phone, int yearsOfExp, int hospitalId, String details) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.phone = phone;
		this.yearsOfExp = yearsOfExp;
		this.hospitalId = hospitalId;
		Details = details;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getYearsOfExp() {
		return yearsOfExp;
	}
	public void setYearsOfExp(int yearsOfExp) {
		this.yearsOfExp = yearsOfExp;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	
}
