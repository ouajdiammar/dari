package tn.esprit.spring.Repo;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Appointment;




public interface AppointmentRepo  extends CrudRepository<Appointment,Long>{
	@Query("SELECT a FROM Appointment a WHERE a.state=:confirmed ")
	List<Appointment> retrieveAllAppointmentByState(@Param("confirmed")String State);
	
	@Query("SELECT a FROM Appointment a WHERE a.dateAppointement=:date ")
	Appointment findByDate(@Param("date")Date date);
	
	

	

 

}
