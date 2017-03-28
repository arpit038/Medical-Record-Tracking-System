package org.arpit.smarthackthon.MedicalRecordTrackingSystem.service;

import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.Data;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.database.DatabaseClass;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Doctor;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Patient;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.SignIn;

public class SignInService {

	private static Map<Integer, SignIn> logins = DatabaseClass.getAllLogins();
	
	public Doctor checkDoctorCredentails(String username,String password){
		for(SignIn login: logins.values()){
			if(login.getEntityType().equalsIgnoreCase("doctor"))
			{
				if(login.getUsername().equals(username) && login.getPassword().equals(password))
					return DatabaseClass.getDoctors().get(login.getUserId());
			}
		}
		return null;
	}
	
	public Patient checkPatientCredentails(String username,String password){
		for(SignIn login: logins.values()){
			if(login.getEntityType().equals("patient"))
			{
				if(login.getUsername().equals(username) && login.getPassword().equals(password))
						return DatabaseClass.getPatients().get(login.getUserId());
			}
		}
		return null;
	}
}
