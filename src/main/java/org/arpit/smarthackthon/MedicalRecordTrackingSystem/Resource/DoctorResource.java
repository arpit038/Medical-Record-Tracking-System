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

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.service.DoctorService;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.service.SignInService;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Departments;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Doctor;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.DoctorSlot;

@Path("/doctors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorResource {

	private DoctorService service = new DoctorService();
	private SignInService signinservice = new SignInService();
	
	@POST
	@Path("/signin")
	public Doctor getDoctor(@QueryParam("username") String username,@QueryParam("password") String password){
		return signinservice.checkDoctorCredentails(username, password);
	}
	
	@GET
	public List<Doctor> getAllDoctors(@QueryParam("hospitalId") int hospitalId,
									  @QueryParam("dept") String dept ){
		if(hospitalId >0){
			if(dept != null)
				return service.getAllDoctors(hospitalId, dept);
			else
				return service.getAllDoctors(hospitalId);
		}
		else{
			if(dept != null)
				return service.getAllDoctors(dept);
			else
				return service.getAllDoctors();
		}
	}
	
	@GET
	@Path("/{doctorId}")
	public Doctor getDoctor(@PathParam("doctorId") int id){
		return service.getDoctor(id);
	}
	
	@PUT
	@Path("/{doctorId}")
	public Doctor updateDoctor(@PathParam("doctorId") int id,Doctor doc){
		doc.setId(id);
		return service.updateDoctor(doc);
	}
	
	@POST
	public Doctor addDoctor(Doctor doc){
		return service.addDoctor(doc);
	}
	
	@DELETE
	@Path("/{doctorId}")
	public Doctor deleteDoctor(@PathParam("doctorId") int id){
		return service.deleteDoctor(id);
	}
	
	@GET
	@Path("/{doctorId}/slots")
	public List<DoctorSlot> getDoctorSlots(@PathParam("doctorId") int id){
		return service.getDoctorSlots(id);
	}
	
	//USECASE 1 & USECASE 2
	@Path("/{doctorId}/appointments")
	public AppointmentResource getAppointments(){
		return new AppointmentResource();
	}
	
	@GET
	@Path("/departments")
	public Departments[] getDepartments(){
		return Departments.values();
	}
}
