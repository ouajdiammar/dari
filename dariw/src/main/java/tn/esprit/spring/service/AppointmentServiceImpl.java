package tn.esprit.spring.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repo.AppointmentRepo;
import tn.esprit.spring.Repo.UserRepository;
import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.User;




@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	AppointmentRepo AppointmentRepository;
	@Autowired
	UserRepository userRepository;

	

	@Override
	public List<Appointment> retrieveAllAppointment() {
	AppointmentRepository.findAll();
	return (List<Appointment>) AppointmentRepository.findAll();
	}
	
	
	
	@Override
	public Appointment addAppointment(Appointment a,Long id) {
           if(userRepository.findById(id)==null   ){
	throw new RuntimeException("no user with this id ");}
	
	a.setUser(userRepository.findById(id).get());
	if(dateverifiacation(a.getDateAppointement())!=null) {
		throw new RuntimeException("this Date is not available ");
	} 
	a.setState("confirmed");
	return	AppointmentRepository.save(a);
	
	}
	public Appointment  dateverifiacation(Date date) {
		return AppointmentRepository.findByDate(date);
		 
	}


	
	
	
	/*@Override
	public Appointment addAppointment(Appointment a,Long id) {
           if(userRepository.findById(id)==null   ){
	throw new RuntimeException("no user with this id ");}
	
	a.setUser(userRepository.findById(id).get());
	
	return	AppointmentRepository.save(a);
	
	}
	*/

	
		
		
	/*
	@Override
	public Appointment addAppointment(Appointment a,Date date) {
	
	
		List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();

		for(Appointment aa:app) {
		//	Appointment aa=new Appointment();
		
		if (aa.getDateAppointement().compareTo(a.getDateAppointement()) > 0) {
			
			a.setState("confirmed");
		//	l.info("appointment is1111111111" + a.getState());
		}
		else if (a.getDateAppointement().compareTo(a.getDateAppointement()) < 0) {
			a.setState("confirmed");
		//	l.info("appointment is22222222" + a.getState());

			
		}
		else {
			a.setState("not confirmed same date");

		//	l.info("appointment is333333333" + a.getState());

		}

	}
		AppointmentRepository.save(a);

		return a;
	}

		*/
		
		
		
		
		
		
		
		
	@Override
	public void deleteAppointment(Long id) {
		
		AppointmentRepository.deleteById(id);		

	}

	@Override
	public Appointment retrieveAppointment(Long id) {
		return AppointmentRepository.findById(id).get();
	}
	
	

	@Override
	public void ConfrmerAppointment(Date date) {
	List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();
/*
		for(Appointment a:app) {
			//Appointment aa=new Appointment();
		
		if (a.getDateAppointement().compareTo(date) > 0) {
			
		a.setState("confirmed");
		l.info("appointment is1111111111" + a.getState());
		}
		else if (a.getDateAppointement().compareTo(date) < 0) {
		a.setState("confirmed");
		l.info("appointment is22222222" + a.getState());

			
		}
		else {
			l.info("appointment is333333333" + a.getState());

		}
		AppointmentRepository.save(a);
		*/
		}

	@Override
	public int countAppointment() {
		int max=0;
		List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();
		for(Appointment appointment:app) {
			max++;
			
		}


		return max;

	}

	/*
	public void RechercheConfirmedApp() {
		AppointmentRepository.retrieveAllAppointmentByState("confirmed");
	//	l.info("appointment is+++++++++++" + AppointmentRepository.retrieveAllAppointmentByState("confirmed"));

	}*/

	
	@Override
	public List<Appointment> rechercheAppointment() {
		List<Appointment> app=(List<Appointment>)AppointmentRepository.retrieveAllAppointmentByState("confirmed");
		
		return app;

		
	}
	/*
@Override
	public void AppointmentToday() {
	List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();
		int max=0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		//Date da=new Date(dateFormat.format(date));
		//l.info("********" + dateFormat.format(date));

		
	
		for(Appointment a:app) {
			//Appointment aa=new Appointment();
			
		if ((a.getDateAppointement().getDay()== date.getDay() ) && (a.getDateAppointement().getMonth()== date.getMonth()) && (a.getDateAppointement().getYear()== date.getYear())) {
			max++;
			
			//l.info("********" + dateFormat.format(date)+a);
		}}
		//l.info("you have "+max+" appointments today++++++++++++" );
}
	*/	
	

	@Override
	public void BlockUserByAttendance() {
		
		List<Appointment> app=(List<Appointment>) AppointmentRepository.findAll();

		for(Appointment a:app) {
			
					if(a.getAttendance().equals("absent") ) {
						
						//a.getClient().setBlock(true);
						AppointmentRepository.save(a);


						List<User> cc=(List<User>) userRepository.findAll();
						for(User cli:cc) {
							AppointmentRepository.save(a);
							//ClientRepository.save(a.getClient());

						}
				
						//l.info("user is Blocked+++++++" + a.getClient().getId()+ "+++++++"+ a.getClient().isBlock());

	}
					}
	
	
	}

	

}
