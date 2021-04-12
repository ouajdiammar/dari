package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.AppointmentFeedBack;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.Repo.AppointmentFeedBackRepository;



@Service
public class AppointmentFeedBackServiceImpl implements AppointmentFeedBackService {
	@Autowired
	AppointmentFeedBackRepository AppointmentFeedBackRepository;
	
	//private static final Logger l= LogManager.getLogger(AppointmentServiceImpl.class);

	@Override
	public  List<AppointmentFeedBack> retrieveAllAppointmentFeedBack() {
		List<AppointmentFeedBack> appF=(List<AppointmentFeedBack>) AppointmentFeedBackRepository.findAll();
		/*for(AppointmentFeedBack appointmentF:appF) {
			//l.info("appointmentFeedBacks +++++++++"+ appointmentF);}*/
		
		return (List<AppointmentFeedBack>) AppointmentFeedBackRepository.findAll() ;
	}

	@Override
	public AppointmentFeedBack addAppointmentFeedBack(AppointmentFeedBack af) {
		List<AppointmentFeedBack> appF=(List<AppointmentFeedBack>) AppointmentFeedBackRepository.findAll();
		int max=0;
		for(AppointmentFeedBack appointmentF:appF) {
			if(appointmentF.isLikes()==true) {
				max++;
			}
			if(max>3) {
				af.setDescriptionFeedBack("good appointment good user");
			
		}
			else {
				af.setDescriptionFeedBack("bad appointment");
			}
		}
		
		AppointmentFeedBackRepository.save(af);
		return af;
	}

	@Override
	public void deleteAppointmentFeedBack(String id) {
		AppointmentFeedBackRepository.deleteById(Long.parseLong(id));		

		
	}

	@Override
	public AppointmentFeedBack updateAppointmentFeedBack(AppointmentFeedBack af) {
		AppointmentFeedBackRepository.save(af);

		return null;
	}

	@Override
	public AppointmentFeedBack retrieveAppointmentFeedBack(String id) {
		AppointmentFeedBack app= AppointmentFeedBackRepository.findById(Long.parseLong(id)).orElse(null);
		return app;
	}

	@Override
	public int countLikes() {
		List<AppointmentFeedBack> appF=(List<AppointmentFeedBack>) AppointmentFeedBackRepository.findAll();
		int max=0;
		for(AppointmentFeedBack appointmentF:appF) {
			if(appointmentF.isLikes()==true) {
				max++;
			}}      
			//l.info("you have +++++++++"+ max+"likes");

		
		
		return max;
	}

	
	}




		
	

