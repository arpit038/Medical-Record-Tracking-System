package org.arpit.smarthackthon.MedicalRecordTrackingSystem.model;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.database.DatabaseClass;

public class PatientSlot {

	private int appointmentId;
	private int indexOfPatient;	//index of patient in the doctor slot
	private int patientId;
	private int doctorSlotId;
	private String status = "pending"; //"pending","accepted","rejected","completed"
	
	public PatientSlot(){
		
	}
	
	public PatientSlot(int appointmentId, int indexOfPatient, int patientId, int doctorSlotId, String status) {
		super();
		this.appointmentId = appointmentId;
		this.indexOfPatient = indexOfPatient;
		this.patientId = patientId;
		this.doctorSlotId = doctorSlotId;
		this.status = status;
	}


	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getIndexOfPatient() {
		return indexOfPatient;
	}

	public void setIndexOfPatient(int indexOfPatient) {
		this.indexOfPatient = indexOfPatient;
	}
	
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int pateintId) {
		this.patientId = pateintId;
	}

	public int getDoctorSlotId() {
		return doctorSlotId;
	}

	public void setDoctorSlotId(int doctorSlotId) {
		this.doctorSlotId = doctorSlotId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}	
}