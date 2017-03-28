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
import javax.ws.rs.core.MediaType;

import org.arpit.smarthackthon.MedicalRecordTrackingSystem.service.HospitalService;
import org.arpit.smarthackthon.MedicalRecordTrackingSystem.model.Hospital;;

@Path("/hospitals")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HospitalResource {

	HospitalService service = new HospitalService();
	
	@GET
	public List<Hospital> getAllHospitals(){
		return service.getAllHospitals();
	}
	
	@GET
	@Path("/{hospitalId}")
	public Hospital getHospital(@PathParam("hospitalId") int id){
		return service.getHospital(id);
	}
	
	@PUT
	@Path("/{hospitalId}")
	public Hospital updateHospital(@PathParam("hospitalId") int id, Hospital hospital){
		hospital.setId(id);
		return service.updateHospital(hospital);
	}
	
	@POST
	public Hospital addHospital(Hospital hospital){
		return service.addHospital(hospital);
	}
	
	@DELETE
	@Path("/{hospitalId}")
	public Hospital deleteHospital(@PathParam("hospitalId") int id){
		return service.deleteHospital(id);
	}
}
