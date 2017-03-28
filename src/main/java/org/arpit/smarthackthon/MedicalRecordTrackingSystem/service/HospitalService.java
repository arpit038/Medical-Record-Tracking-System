package org.arpit.smarthackthon.MedicalRecordTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.database.DatabaseClass;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Hospital;

public class HospitalService {

	private Map<Integer,Hospital> hospitals = DatabaseClass.getHospitals();
	
	public List<Hospital> getAllHospitals(){
		return new ArrayList<>(hospitals.values());
	}
	
	public Hospital getHospital(int id){
		return hospitals.get(id);
	}
	
	public Hospital addHospital(Hospital hospital){
		hospital.setId(hospitals.size()+1);
		hospitals.put(hospital.getId(), hospital);
		return hospital;
	}
	
	public Hospital updateHospital(Hospital hospital){
		if(hospital.getId() <=0)
			return null;
		hospitals.put(hospital.getId(), hospital);
		return hospital;
	}
	
	public Hospital deleteHospital(int id){
		Hospital hospital = hospitals.get(id);
		hospitals.remove(id);
		return hospital;
	}
}
