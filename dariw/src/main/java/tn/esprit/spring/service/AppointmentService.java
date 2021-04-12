package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.User;


public interface AppointmentService {
	
	List<Appointment> retrieveAllAppointment();
	void deleteAppointment(Long id);
	Appointment retrieveAppointment(Long id);
	void ConfrmerAppointment(Date date);
	int countAppointment();
	//void RechercheConfirmedApp();
	public List<Appointment> rechercheAppointment();
	//public void AppointmentToday();
	public void BlockUserByAttendance();
     Appointment addAppointment(Appointment a,Long id);
	//Appointment addAppointment(Appointment a, Date date);
	


	
    

}
