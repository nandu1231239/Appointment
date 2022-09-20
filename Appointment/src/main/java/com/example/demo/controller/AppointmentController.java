package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;

@RestController
public class AppointmentController {

	 @Autowired 
	 private AppointmentService appointmentservice;
	 
	 Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	   
	 
	 
	 
		// Save operation
		@PostMapping("/appointment")
		public Appointment saveAppointment(@RequestBody Appointment appointment) {
			Appointment respList = null;
			try {
				respList = appointmentservice.saveAppointment(appointment);
				logger.info("saving data");
			} catch (Exception e) {
				logger.error("getting error while saving appointment");
			}
			return respList;
		}

		// Read operation
		@GetMapping("/appointment/{appointmentid}")
		private Appointment getBooks(@PathVariable("appointmentid") int appointmentId) {
			Appointment respList = null;
			try {
				respList = appointmentservice.getAppointmentById(appointmentId);
				logger.info("reading a appointment by the id");
			} catch (Exception e) {
				logger.error("getting error while getting appointment");
			}
			return respList;
		}
	 
	// Update operation
	@PutMapping(value= "/appointments/{appointmentId}")
	public Appointment updateApp(@RequestBody Appointment appointment,@PathVariable("appointmentId") int appointmentId) {
		Appointment respList = null;
		try {
			 appointmentservice.updateAppointment(appointment,appointmentId);
			logger.info("updating the appointment by id");
		} catch (Exception e) {
			logger.error("getting error while updating the appointment");
		}
		return respList;
	}
	 
	// Delete operation
	@GetMapping("/appointmentdelete/{appointmentid}")
	public String deleteDepartmentById(@PathVariable("appointmentid") int appointmentid) {
		try {
			appointmentservice.deleteAppointmentById(appointmentid);
			logger.info("deleting the appointment by id");
		} catch (Exception e) {
			logger.error("getting error while deleting the appointment");
		}
		return "Deleted Successfully";
	}
	    
	  
	
	//getting all the data in between given time period
	@PostMapping("/appointmentbetweenperiod")
	private List<Appointment> getAllAppointments(@RequestParam("startdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startdate,@RequestParam("enddate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime enddate)
	{
		List<Appointment> respList = null;
		try {
			 respList=appointmentservice.getAllAppointments(startdate,enddate);
			logger.info("getting the appointment list by startdate and enddate ");
		} catch (Exception e) {
			logger.error("getting error while extracting the appointment list by startdate and enddate");
		}
		return respList;
		
	}
}
