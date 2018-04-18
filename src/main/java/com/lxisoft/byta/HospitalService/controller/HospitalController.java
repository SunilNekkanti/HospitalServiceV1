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
package com.lxisoft.byta.HospitalService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.byta.HospitalService.domain.Patient;
import com.lxisoft.byta.HospitalService.service.MessageListener;
import com.lxisoft.byta.HospitalService.service.PublishHospitalService;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO Provide a detailed description here 
 * @author Sarangi Balu
 * , 
 */
@Slf4j
@RestController
public class HospitalController
{
	MessageListener messageListener;
	
	PublishHospitalService publishHospitalService;
	
	public HospitalController(MessageListener messageListener,PublishHospitalService publishHospitalService)
	{
		this.messageListener=messageListener;
		this.publishHospitalService=publishHospitalService;
	}
	
	  @RequestMapping("/getMessage")
	  public void getMessage(@RequestParam("id") Integer id)
	  {
		  Patient patient=Patient.builder().patientId(id).build();
		  
		  publishHospitalService.sendBookedPatientSucessRecords(patient);
		  
		  log.info("getMessage: {} in PatientController",patient );
	  }
	
	
}
