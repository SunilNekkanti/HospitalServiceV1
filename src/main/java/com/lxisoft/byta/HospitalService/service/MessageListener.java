/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lxisoft.byta.HospitalService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.lxisoft.byta.HospitalService.stream.HospitalStream;
import com.lxisoft.byta.HospitalService.domain.Admission;
import com.lxisoft.byta.HospitalService.domain.Consultation;
import com.lxisoft.byta.HospitalService.domain.Patient;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO Provide a detailed description here 
 * @author Sarangi Balu
 * , 
 */
@Component
@Slf4j
public class MessageListener 
{
	
	
	private PublishHospitalService publishHospitalService;
	
	public MessageListener(PublishHospitalService publishHospitalService)
	{
		this.publishHospitalService=publishHospitalService;
	}
	
	
	@StreamListener(HospitalStream.BOOKING_IN)
	public void listenToBookingSucessResponse(@Payload Patient patient)
	{
		
		//consultationRepository.save(consultation);
		
		log.info("listenToMsg: {} in MessageListener listenToBookingResponse",patient );
		
	    publishHospitalService.sendBookedPatientSucessRecords(patient);
		
		log.info("MessageListener send BookedPatientSucess", patient);
	
	}
	
	
	
	@StreamListener(HospitalStream.ASSET_BED_IN)
	public void listenToBedAllocatedMsg(@Payload Admission admission)
	{
		
		//consultationRepository.save(consultation);
		
		log.info("listenToMsg: {} in MessageListener listenToBedAllocatedMsg",admission);
		
	    publishHospitalService.sendAdmissionSucess(admission);
		
		log.info("MessageListener send sendAdmissionSucess", admission);
	
	}
	
	
	
	
	
	@StreamListener(HospitalStream.CONSULTATION_IN)
	public void listenToConsultationCreateRequest(@Payload Consultation consultation)
	{
		
		//consultationRepository.save(consultation);
		
		log.info("listenToMsg: {} in MessageListener listenToConsultationCreateRequest",consultation);
		
	    publishHospitalService.sendConsultationSucess(consultation);
		
		log.info("MessageListener send sendConsultationSucess", consultation);
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
