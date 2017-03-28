package org.arpit.smarthackthon.MedicalRecordTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.database.DatabaseClass;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Doctor;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.DoctorSlot;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.SignIn;

public class DoctorService {

	private Map<Integer, Doctor> doctors = DatabaseClass.getDoctors();
	
	public List<Doctor> getAllDoctors(int hospitalId){
		List<Doctor> list = new ArrayList<>();
		for(Doctor doc : doctors.values()){
			if(doc.getHospitalId() == hospitalId)
				list.add(doc);
		}
		return list;
	}
	
	public List<Doctor> getAllDoctors(String dept){
		List<Doctor> list = new ArrayList<>();
		for(Doctor doc : doctors.values()){
			if(doc.getDept().equalsIgnoreCase(dept))
				list.add(doc);
		}
		return list;
	}
	
	public List<Doctor> getAllDoctors(int hospitalId, String dept){
		List<Doctor> list = new ArrayList<>();
		for(Doctor doc : doctors.values()){
			if(doc.getDept().equalsIgnoreCase(dept) && doc.getHospitalId()==hospitalId)
				list.add(doc);
		}
		return list;
	}
	
	public List<Doctor> getAllDoctors(){
		return new ArrayList<>(doctors.values());
	}
	
	public Doctor getDoctor(int id){
		return doctors.get(id);
	}
	
	public List<DoctorSlot> getDoctorSlots(int id){
		ArrayList<DoctorSlot> list = new ArrayList<>();
		for(DoctorSlot slot: DatabaseClass.getDoctorSlots().values()){
			if(slot.getDocId() == id)
				list.add(slot);
		}
		return list;
	}
	
	public Doctor updateDoctor(Doctor doctor){
		if(doctor.getId() <= 0)
			return null;
		doctors.put(doctor.getId(), doctor);
		return doctor;
	}
	
	public Doctor addDoctor(Doctor doctor){
		doctor.setId(doctors.size()+1);
		doctors.put(doctor.getId(), doctor);
		return doctor;
	}
	
	public Doctor deleteDoctor(int docId){
		Doctor doctor = doctors.get(docId);
		doctors.remove(docId);
		return doctor;
	}
}
