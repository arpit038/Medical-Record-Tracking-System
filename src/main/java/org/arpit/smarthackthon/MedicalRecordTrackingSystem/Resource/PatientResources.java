package org.arpit.smarthackthon.MedicalRecordTrackingSystem.Resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Patient;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.PatientMedicalHistory;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.PatientSlot;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.service.PatientMedicalHistoryService;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.service.PatientService;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.service.PatientSlotService;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.service.SignInService;

@Path("/patients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientResources {

	private PatientService service = new PatientService();
	private SignInService signinservice = new SignInService();
	private PatientSlotService patientSlotService = new PatientSlotService();
	private PatientMedicalHistoryService historyService = new PatientMedicalHistoryService();
	
	@POST
	@Path("/signin")
	public Patient getPatient(@QueryParam("username") String username,@QueryParam("password") String password){
		return signinservice.checkPatientCredentails(username, password);
	}
	
	@GET
	public List<Patient> getAllPatients(){
		return service.getAllPatient();
	}
	
	@GET
	@Path("/{patientId}")
	public Patient getPatient(@PathParam("patientId") int id){
		return service.getPatient(id);
	}
	
	@POST
	public Patient addPatient(Patient patient){
		return service.addPatient(patient);
	}
	
	@PUT
	@Path("/{patientId}")
	public Patient updatePatient(@PathParam("patientId") int id,Patient patient){
		patient.setId(id);
		return service.updatePatient(patient);
	}
	
	@GET
	@Path("/{patientId}/appointments")
	public List<PatientSlot> getAppointments(@QueryParam("status") String status,
											 @PathParam("patientId") int patientId){
		return patientSlotService.getPatientSlots(patientId,status);
	}
	
	@GET
	@Path("/{patientId}/appointments/{appointmentId}")
	public PatientSlot getAppointment(@PathParam("appointmentId") int appointmentid){
		return patientSlotService.getAppointment(appointmentid);
	}
	
	@POST
	@Path("/{patientId}/appointments")
	public PatientSlot addAppointments(@PathParam("patientId") int patientId,PatientSlot patientSlot){
		patientSlot.setPatientId(patientId);
		return patientSlotService.addPatientSlot(patientSlot);
	}
	
	@DELETE
	@Path("/{patientId}/appointments/{appointmentId}")
	public PatientSlot deleteAppointment(@PathParam("appointmentId") int appointmentId){
		return patientSlotService.deletePatientSlot(appointmentId);
	}
	
	@GET
	@Path("/{patientId}/medicalhistory")
	public List<PatientMedicalHistory> getMedicalHistory(@PathParam("patientId") int patientId){
		return historyService.getPatientMedicalHistory(patientId);
	}
	
	@GET
	@Path("/{patientId}/medicalhistory/{appointmentId}")
	public PatientMedicalHistory getMedicalHistory(@PathParam("patientId") int patientId,
														 @PathParam("appointmentId") int appointmentId){
		return historyService.getPatientMedicalHistory(patientId,appointmentId);
	}
}
