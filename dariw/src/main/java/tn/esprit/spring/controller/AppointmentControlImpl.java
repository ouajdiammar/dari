package tn.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.service.AppointmentService;

@RestController
@RequestMapping("/app")
public class AppointmentControlImpl {
	@Autowired
	AppointmentService AppointmentService;
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-appointment

	@GetMapping("/retrieve-all-appointment")
	 @ResponseBody
	 public List<Appointment> getAppointments() {
	 List<Appointment> list = AppointmentService.retrieveAllAppointment();
	 return list;
	} 
	// Ajouter User : http://localhost:8081/dari/app/addappointment
		  @PostMapping("/addappointment/{id}")
		  @ResponseBody
		  public Appointment addAppointment(@RequestBody Appointment a,@PathVariable("id") Long id ) {
		  Appointment app = AppointmentService.addAppointment(a,id);
		 return app;
		  }
		  
	
		
		  
		  /* Ajouter User : http://localhost:8081/SpringMVC/servlet/add-appointment
		  @PostMapping("/addappointment/{id}")
		  @ResponseBody
		  public Appointment addAppointment(@RequestBody Appointment a,@PathVariable("id") Long id ) {
		  Appointment app = AppointmentService.addAppointment(a,id);
		 return app;
		  }	*/  
		  
		  
		  

		  
		  
		  //http://localhost:8081/dari/app/remove-user/{user-id}
		  @DeleteMapping("/remove-user/{appointment-id}")
		   @ResponseBody
		   public void removeAppointment(@PathVariable("appointment-id") Long id) {
		       AppointmentService.deleteAppointment(id);;
		   }
		  //http://localhost:8081/SpringMVC/servlet/count
		  @GetMapping("/countappointment")
		   @ResponseBody
		   public int CountAppointment() {
		   return AppointmentService.countAppointment();
		   }
		  
		//http://localhost:8081/dari/app/recherche
		  @GetMapping("/recherche")
		   @ResponseBody
			 public List<Appointment> rechercheConfirmedAppointments() {
			  List<Appointment> list =AppointmentService.rechercheAppointment();
		return list;
		   }
		  
		//  : http://localhost:8081/dari/app/BlockUser
		  @GetMapping("/BlockUser")
		  @ResponseBody
		  public void BlockUser() {
		  AppointmentService.BlockUserByAttendance();
		 
		  }
	

}
