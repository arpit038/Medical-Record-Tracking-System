package org.arpit.smarthackthon.MedicalRecordTrackingSystem.Resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.PatientMedicalHistory;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.PatientSlot;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.service.PatientMedicalHistoryService;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.service.PatientSlotService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AppointmentResource {

	PatientSlotService patientSlotService = new PatientSlotService();
	PatientMedicalHistoryService service = new PatientMedicalHistoryService();
	
	@GET
	public List<PatientSlot> getAppointments(@PathParam("doctorId") int id,
											 @QueryParam("status") String status){
		return patientSlotService.getAppointments(status,id);
	}
	
	//USECASE 1 & USECASE 2
	@GET
	@Path("/{appointmentId}")
	public PatientSlot getAppointment(@PathParam("appointmentId") int appointmentId){
		return patientSlotService.getAppointment(appointmentId);
	}
	
	@PUT
	@Path("/{appointmentId}")
	public PatientSlot updateAppointment(@PathParam("appointmentId") int appointmentId, @QueryParam("accepted") boolean accepted){
		return patientSlotService.updateAppointment(appointmentId,accepted); 
	}
	
	//USECASE 1
	@POST
	@Path("/{appointmentId}")
	public PatientMedicalHistory addMedicalHistory(@PathParam("appointmentId") int appointmentId, PatientMedicalHistory history){
		if(patientSlotService.getAppointment(appointmentId).getStatus().equalsIgnoreCase("completed"))
			return null;
		patientSlotService.getAppointment(appointmentId).setStatus("completed");;
		history.setAppointmentId(appointmentId);
		return service.addMedicalHistory(history);
	}
	
	//USECASE 2
	@GET
	@Path("/{appointmentId}/medicalhistory")
	public PatientMedicalHistory getMedicalHistory(@PathParam("appointmentId") int id){
		return service.getMedicalHistory(id);	//return only one history for current appointment
	}
	
	@PUT
	@Path("/{appointmentId}/medicalhistory")
	public PatientMedicalHistory updateMedicalHistory(@PathParam("appointmentId") int id,PatientMedicalHistory history){
		if(patientSlotService.getAppointment(id).getStatus().equalsIgnoreCase("completed"))
		{	
			history.setAppointmentId(id);
			return service.updateMedicalHistory(history);
		}
		else
			return null;
	}	
}
