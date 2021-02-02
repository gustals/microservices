package com.microservices.payroll.services;

import org.springframework.stereotype.Service;

import com.microservices.payroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, int days) {
		return new Payment("Gustavo", 100.0, days);
	}
	
}
