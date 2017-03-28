package org.arpit.smarthackthon.MedicalRecordTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.database.DatabaseClass;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.DoctorSlot;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.PatientSlot;

public class PatientSlotService {

	private Map<Integer,PatientSlot> patientSlots = DatabaseClass.getPatientSlots();
	private Map<Integer,DoctorSlot> doctorSlots = DatabaseClass.getDoctorSlots();
	
	//For doctor to get his/her all appointments (Current or past based on completed value)
	public List<PatientSlot> getAppointments(String status,int docId){
		ArrayList<PatientSlot> list = new ArrayList<>();
		for(PatientSlot slot: patientSlots.values()){
			if(doctorSlots.get(slot.getDoctorSlotId()).getDocId() == docId && slot.getStatus().equalsIgnoreCase(status))
				list.add(slot);
		}
		return list;
	}
	
	//For doctor to get his/her particular appointments
	public PatientSlot getAppointment(int appointmentId){
		if(appointmentId <=0)
			return null;
		for(PatientSlot slot: patientSlots.values()){
			if(slot.getAppointmentId() == appointmentId)
				return slot;
		}
		return null;
	}
	
	//For patient to get his/her all booked slots
	public List<PatientSlot> getPatientSlots(int patientId,String status){
		ArrayList<PatientSlot> list = new ArrayList<>();
		for(PatientSlot slot: patientSlots.values()){
			if(slot.getPatientId() == patientId && slot.getStatus().equalsIgnoreCase(status))
				list.add(slot);
		}
		return list;
	}
	
	//For Patient to add an appointment
	public PatientSlot addPatientSlot(PatientSlot patientSlot){
		patientSlot.setAppointmentId(patientSlots.size()+1);
		patientSlot.setStatus("pending");
		patientSlots.put(patientSlot.getAppointmentId(), patientSlot);
		return patientSlot;
	}
	
	//For doctors to accept and reject an appointment
	public PatientSlot updateAppointment(int patientSlotId, boolean status){
		if(status)
			patientSlots.get(patientSlotId).setStatus("accepted");
		else
			patientSlots.get(patientSlotId).setStatus("rejected");
		return patientSlots.get(patientSlotId);
	}
	
	//For a Patient to delete an appointment
	public PatientSlot deletePatientSlot(int appointmentId){
		PatientSlot patientSlot = patientSlots.get(appointmentId);
		patientSlots.remove(appointmentId);
		return patientSlot;
	}
}
