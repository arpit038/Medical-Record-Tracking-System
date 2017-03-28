package org.arpit.smarthackthon.MedicalRecordTrackingSystem.database;

import java.util.HashMap;
import java.util.Map;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Doctor;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.DoctorSlot;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Hospital;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Patient;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.PatientMedicalHistory;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.PatientSlot;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.SignIn;

public class DatabaseClass {

	private static Map<Integer, SignIn> signIns = new HashMap<>();
	private static Map<Integer,Hospital> hospitals = new HashMap<>();
	private static Map<Integer,Doctor> doctors = new HashMap<>();
	private static Map<Integer,DoctorSlot> doctorSlots = new HashMap<>();
	private static Map<Integer, Patient> patients = new HashMap<>();
	private static Map<Integer, PatientSlot> patientSlots = new HashMap<>();
	private static Map<Integer, PatientMedicalHistory> allHistory = new HashMap<>();
	
	static{
		signIns.put(1, new SignIn(1,1,"patient1","patient1","patient"));
		signIns.put(2, new SignIn(2,2,"patient2","patient2","patient"));
		signIns.put(3, new SignIn(3,3,"patient3","patient3","patient"));
		
		signIns.put(4, new SignIn(4,1,"doctor1","doctor1","doctor"));
		signIns.put(5, new SignIn(5,2,"doctor2","doctor2","doctor"));
		signIns.put(6, new SignIn(6,3,"doctor3","doctor3","doctor"));
		signIns.put(7, new SignIn(7,4,"doctor4","doctor4","doctor"));
		
		//Admin Login
		//signIns.put(8, new SignIn(8,1,"admin","admin","Admin"));
		
		hospitals.put(1, new Hospital(1,"ABC Hospital","Address 1","Jabalpur","Madhya Pradesh",482005,123456,"Details of the hospital 1"));
		hospitals.put(2, new Hospital(2,"XYZ Hospital","Address 2","Jabalpur","Madhya Pradesh",482005,123456,"Details of the hospital 2"));
		
		doctors.put(1, new Doctor(1,"Dr. Doctor Name1","Physician",123456,15,1,"Details of the doctor 1"));
		doctors.put(2, new Doctor(2,"Dr. Doctor Name2","Radiologist",654321,5,1,"Details of the doctor 2"));
		doctors.put(3, new Doctor(3,"Dr. Doctor Name3","Cardiologist",123789,3,2,"Details of the doctor 3"));
		doctors.put(4, new Doctor(4,"Dr. Doctor Name4","Gynaecology",987654,10,2,"Details of the doctor 4"));
		
		doctorSlots.put(1, new DoctorSlot(1,1,1000,1900,"Monday"));
		doctorSlots.put(2, new DoctorSlot(2,1,1000,1900,"Tuesday"));
		doctorSlots.put(3, new DoctorSlot(3,1,1000,1900,"Wednesday"));
		doctorSlots.put(4, new DoctorSlot(4,2,900,1200,"Thrusday"));
		doctorSlots.put(5, new DoctorSlot(5,2,900,1200,"Friday"));
		doctorSlots.put(6, new DoctorSlot(6,2,900,1200,"Saturday"));
		doctorSlots.put(7, new DoctorSlot(7,3,1100,1500,"Sunday"));
		doctorSlots.put(8, new DoctorSlot(8,4,800,1100,"Friday"));
		doctorSlots.put(9, new DoctorSlot(9,4,800,1100,"Saturday"));
		
		patients.put(1, new Patient(1,"Patient1","lastname1","Jabalpur","Madhya Pradesh",123456,25,'M','U',"A+","Details about patient"));
		patients.put(2, new Patient(2,"Patient2","lastname2","Jabalpur","Madhya Pradesh",123456,25,'M','U',"A+","Details about patient"));
		patients.put(3, new Patient(3,"Patient3","lastname3","Jabalpur","Madhya Pradesh",123456,25,'M','U',"A+","Details about patient"));
	}
	static{
		patientSlots.put(1, new PatientSlot(1,1,1,1,"completed"));
		patientSlots.put(2, new PatientSlot(2,2,2,1,"completed"));
		patientSlots.put(3, new PatientSlot(3,3,3,1,"pending"));
		patientSlots.put(4, new PatientSlot(4,1,1,2,"pending"));
		
		allHistory.put(1, new PatientMedicalHistory(1,"Symptoms 1","Test 1","Medicines 1","Comments 1"));
		allHistory.put(2, new PatientMedicalHistory(2,"Symptoms 2","Test 1","Medicines 1","Comments 1"));
	}
	
	public static Map<Integer,Hospital> getHospitals(){
		return hospitals;
	}
	
	public static Map<Integer, Doctor> getDoctors(){
		return doctors;
	}
	
	public static Map<Integer, DoctorSlot> getDoctorSlots(){
		return doctorSlots;
	}
	
	public static Map<Integer, Patient> getPatients(){
		return patients;
	}
	
	public static Map<Integer, PatientSlot> getPatientSlots(){
		return patientSlots;
	}
	
	public static Map<Integer, PatientMedicalHistory> getAllHistory(){
		return allHistory;
	}
	
	public static Map<Integer, SignIn> getAllLogins() {
		return signIns;
	}
}
