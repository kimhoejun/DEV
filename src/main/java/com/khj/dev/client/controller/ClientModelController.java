package com.khj.dev.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khj.dev.client.service.ClientModelService;

@RestController
@RequestMapping("/client")
public class ClientModelController {

	private static Logger logger = LoggerFactory.getLogger(ClientModelController.class);
	
	@Autowired
	private ClientModelService service;
	
	@GetMapping("/send")
	public String send() {
		
		String result = "";
		
		try {
		
			logger.info(">>>>>> client GetMapping [send] start...");
			result = service.jsonToServiceEndpoint();
			logger.info("<<<<<< client GetMapping [send] result : {}", result);
			
		} catch(Exception e) {
			
			logger.error("<<<<<< err msg : {}", e.getMessage());
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("Err Send:")
			.append(e.getMessage());
			
			result = buffer.toString();
		}
		
		return result;
	}
	
	
	
}
