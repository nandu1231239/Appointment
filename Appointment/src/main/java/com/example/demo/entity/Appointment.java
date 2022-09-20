package com.example.demo.entity;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;
	
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime datetime ;
	
	@Column
    private String duration;
	
	@Column
    private String purpose;


	
	public Appointment() {
	}



	public Appointment(int appointmentId, LocalDateTime datetime, String duration, String purpose) {
		this.appointmentId = appointmentId;
		this.datetime = datetime;
		this.duration = duration;
		this.purpose = purpose;
	}



	public int getAppointmentId() {
		return appointmentId;
	}



	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}



	public LocalDateTime getDatetime() {
		return datetime;
	}



	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}



	public String getDuration() {
		return duration;
	}



	public void setDuration(String duration) {
		this.duration = duration;
	}



	public String getPurpose() {
		return purpose;
	}



	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}



	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", datetime=" + datetime + ", duration=" + duration
				+ ", purpose=" + purpose + "]";
	}



	


	
	
	

//	@Override
//	public String toString() {
//		return "Appointment [appointmentId=" + appointmentId + ", Datetime=" + Datetime + ", duration=" + duration
//				+ ", purpose=" + purpose + "]";
//	}
	
	

}
