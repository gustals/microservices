package com.microservices.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.payroll.entities.Payment;
import com.microservices.payroll.entities.Worker;
import com.microservices.payroll.feignClient.WorkerFeignClient;

@Service
public class PaymentService {
	
	
	private static final Logger log = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, int days) throws JsonMappingException, JsonProcessingException {
		
		 
		Double valueDaily;
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> result =  new HashMap<>();
		String resultString = mapper.writeValueAsString(workerFeignClient.findById(workerId).getBody());
		
		log.info("log string = "+resultString);
		
		result=mapper.readValue(resultString, HashMap.class);
		
		log.info("log map = "+resultString);
		valueDaily = (Double) result.get("dailyIncome");
		
		log.info("log value = "+valueDaily + "tipe = "+valueDaily.getClass());
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment((String) result.get("name"), (Double) result.get("dailyIncome"), days);
	}
	
}
