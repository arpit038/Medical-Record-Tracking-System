package org.arpit.smarthackthon.MedicalRecordTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.database.DatabaseClass;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.PatientMedicalHistory;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.PatientSlot;

public class PatientMedicalHistoryService {

	private Map<Integer, PatientMedicalHistory> wholeHistory = DatabaseClass.getAllHistory();
	private Map<Integer, PatientSlot> appointments = DatabaseClass.getPatientSlots();
	

	public PatientMedicalHistory getMedicalHistory(int appointmentId){
		return wholeHistory.get(appointmentId);
	}
	
	public List<PatientMedicalHistory> getPatientMedicalHistory(int patientId){
		ArrayList<Integer> patientAppointments = new ArrayList<>();
		for(PatientSlot slot: appointments.values()){
			if(slot.getPatientId() == patientId)
				patientAppointments.add(slot.getAppointmentId());
		}
		ArrayList<PatientMedicalHistory> list = new ArrayList<>();
		for(PatientMedicalHistory history: wholeHistory.values()){
			if(patientAppointments.contains(history.getAppointmentId())==true)
				list.add(history);
		}
		return list;
	}
	
	public PatientMedicalHistory getPatientMedicalHistory(int patientId, int appointmentId){
		ArrayList<PatientMedicalHistory> list = new ArrayList<>();
		for(PatientMedicalHistory history: wholeHistory.values()){
			if(history.getAppointmentId()==appointmentId)
				return history;
		}
		return null;
	}
	
	public PatientMedicalHistory updateMedicalHistory(PatientMedicalHistory history){
		wholeHistory.put(history.getAppointmentId(), history);
		return history;
	}
	
	public PatientMedicalHistory addMedicalHistory(PatientMedicalHistory history){
		wholeHistory.put(history.getAppointmentId(), history);
		return history;
	}
}
