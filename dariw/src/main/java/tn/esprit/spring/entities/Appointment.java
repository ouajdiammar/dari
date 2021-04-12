package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;






@Entity
@Table (name="T_appointment")


public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////////////////////////
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long IdAppointement;
	
	@Temporal(TemporalType.DATE)
	private Date dateAppointement;
	

	private String state;
	
	private String Attendance;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	User user;
/////////////////////////////////////////////////////////
	
	
/////////////////////////////////////////////////

	public Long getIdAppointement() {
		return IdAppointement;
	}



	public void setIdAppointement(Long idAppointement) {
		IdAppointement = idAppointement;
	}



	public Date getDateAppointement() {
		return dateAppointement;
	}



	public void setDateAppointement(Date dateAppointement) {
		this.dateAppointement = dateAppointement;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Appointment [IdAppointement=" + IdAppointement + ", dateAppointement=" + dateAppointement + ", state="
				+ state + ",  user=" + user + "]";
	}



	public Appointment(Long idAppointement, Date dateAppointement, String state, User user) {
		super();
		IdAppointement = idAppointement;
		this.dateAppointement = dateAppointement;
		this.state = state;
		this.user = user;
	}



	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getAttendance() {
		return Attendance;
	}



	public void setAttendance(String attendance) {
		Attendance = attendance;
	}
}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	