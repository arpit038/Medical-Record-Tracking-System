package org.arpit.smarthackthon.MedicalRecordTrackingSystem.model;

public class PatientMedicalHistory {

	private int appointmentId;
	private String symptoms;
	private String tests;
	private String medicines;
	private String comments;
	
	public PatientMedicalHistory(){
		
	}
	
	public PatientMedicalHistory(int appointmentId, String symptoms, String tests, String medicines, String comments) {
		super();
		this.appointmentId = appointmentId;
		this.symptoms = symptoms;
		this.tests = tests;
		this.medicines = medicines;
		this.comments = comments;
	}


	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getTests() {
		return tests;
	}
	public void setTests(String tests) {
		this.tests = tests;
	}
	public String getMedicines() {
		return medicines;
	}
	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
