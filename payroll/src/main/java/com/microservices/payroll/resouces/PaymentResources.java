package com.microservices.payroll.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.microservices.payroll.entities.Payment;
import com.microservices.payroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment (@PathVariable Long workerId, @PathVariable Integer days) throws JsonMappingException, JsonProcessingException{
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
	
}
