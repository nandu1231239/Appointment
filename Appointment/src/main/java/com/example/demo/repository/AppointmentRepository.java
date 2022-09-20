package com.example.demo.repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer>  {

	
	@Query(value = "from Appointment t where datetime BETWEEN :startDate  AND :endDate")
	public List<Appointment> getAllBetweenDates(@Param("startDate")LocalDateTime startDate,@Param("endDate")LocalDateTime endDate);

	

	

	

}
