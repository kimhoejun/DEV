package com.khj.dev.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khj.dev.client.service.ClientModelService;

@RestController
@RequestMapping("/client")
public class ClientModelController {

	@Autowired
	private static ClientModelService service;
	
	public ClientModelController() {
		// TODO Auto-generated constructor stub
		service = new ClientModelService();
	}
	
	
	@GetMapping("/send")
	public String send() {
		
		String result = "";
		
		try {
		
			result = service.jsonToServiceEndpoint();
			
		} catch(Exception e) {
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("Err Send:")
			.append(e.getMessage());
			
			result = buffer.toString();
		}
		
		return result;
	}
	
	
	
}
