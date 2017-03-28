package org.arpit.smarthackthon.MedicalRecordTrackingSystem.model;

public class Patient{

	int id;
	String firstame;
	String lastname;
	String city;
	String state;
	int phone;
	int age;
	char gender;		//M,F
	char maritalStatus; //M,U
	String bloodGroup;
	String details;		//details about allergies etc.
	
	public Patient(){
		
	}
	
	public Patient(int id, String firstame, String lastname, String city, String state, int phone, int age, char gender,
			char maritalStatus, String bloodGroup, String details) {
		super();
		this.id = id;
		this.firstame = firstame;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.bloodGroup = bloodGroup;
		this.details = details;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstame() {
		return firstame;
	}
	public void setFirstame(String firstame) {
		this.firstame = firstame;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(char maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
