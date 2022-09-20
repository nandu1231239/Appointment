package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	 private AppointmentRepository appointmentrepository;

		public Appointment saveAppointment(Appointment appointment) {
			return appointmentrepository.save(appointment);
		}


		public Appointment getAppointmentById(int appointmentId) {
		
			return appointmentrepository.findById(appointmentId).get();  
		}

		public Appointment updateAppointment(Appointment appointment,int appointmentId) {
			
			 Optional<Appointment> appointmentOptional = appointmentrepository.findById(appointmentId);
			 if (appointmentOptional.isPresent()) {
				 Appointment newAppointment = appointmentOptional.get();
				 newAppointment.setAppointmentId(appointmentId);
				 newAppointment.setDatetime(appointment.getDatetime());
				 newAppointment.setDuration(appointment.getDuration());
				 newAppointment.setPurpose(appointment.getPurpose());
				 return appointmentrepository.save(newAppointment);
			 }
			 return null;
		}

		public void deleteAppointmentById(int appointmentid) {
			appointmentrepository.deleteById(appointmentid); 
			
		}

		public List<Appointment> getAllAppointments(LocalDateTime startdate,LocalDateTime enddate) {
		
			
			return appointmentrepository.getAllBetweenDates(startdate, enddate);
			  
		}



	

}
