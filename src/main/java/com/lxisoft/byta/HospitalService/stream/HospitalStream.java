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
package com.lxisoft.byta.HospitalService.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * TODO Provide a detailed description here 
 * @author Sarangi Balu
 * , 
 */
public interface HospitalStream
{
	String BOOKING_IN="booking-in",BOOKED_PATIENTS_RECORDS_OUT="booking-out",ASSET_BED_IN="admission-in",ADMISSION_OUT="admission-out",CONSULTATION_IN="consultation-in",CONSULTATION_OUT="consultation-out"; 
	 
	 @Input(BOOKING_IN)
	 SubscribableChannel getBookingSucessResponse();
	 
	 @Output(BOOKED_PATIENTS_RECORDS_OUT)
	 MessageChannel setBookedPatientsSucess();
	 
	 @Input(ASSET_BED_IN)
	 SubscribableChannel getAssetBedAllocatedResponse();
	 
	 @Output(ADMISSION_OUT)
	 MessageChannel  setAdmissionSucess();
	 
	 @Input(CONSULTATION_IN)
	 SubscribableChannel getConsultationCreateRequest();
	 
	 @Output(CONSULTATION_OUT)
	 MessageChannel  setConsultationResponse();
	
}
