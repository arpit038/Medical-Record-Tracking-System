package org.arpit.smarthackthon.MedicalRecordTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.database.DatabaseClass;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Patient;

public class PatientService {

	private Map<Integer,Patient> patients = DatabaseClass.getPatients();
	
	public List<Patient> getAllPatient(){
		return new ArrayList<>(patients.values());
	}
	
	public Patient getPatient(int id){
		return patients.get(id);
	}
	
	public Patient addPatient(Patient patient){
		patient.setId(patients.size()+1);
		patients.put(patient.getId(), patient);
		return patient;
	}
	
	public Patient updatePatient(Patient patient){
		patients.put(patient.getId(), patient);
		return patient;
	}
}
