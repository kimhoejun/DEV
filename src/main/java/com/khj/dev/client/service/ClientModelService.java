package com.khj.dev.client.service;

import org.springframework.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khj.dev.common.model.TestModel;

@Service
public class ClientModelService {

	private static Logger logger = LoggerFactory.getLogger(ClientModelService.class);
	
	private static RestTemplate restTemplate = new RestTemplate();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public String jsonToServiceEndpoint() {
		
		String result = "";
		
		try {
		
			// Read json file
			TestModel model = objectMapper.readValue(new ClassPathResource("templates/request.json").getInputStream(), TestModel.class);
			logger.info(">>>>>> client service model.getLoanRqsNo : {}", model.getLoanRqsNo());
			
			// request header
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			// Header + reqBody
//			HttpEntity<String> reqHttpEntity = new HttpEntity<String>(model.getLoanRqsNo(), headers);
			
			StringBuffer buffer = new StringBuffer();
			buffer.append("http://localhost:8080/serverEndpoints/models/").append(model.getLoanRqsNo());
			
			String url = buffer.toString();
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			logger.info("<<<<<< client service response: {}", response.getBody());
			
			result = response.getBody();
			
		} catch(Exception e) {
			logger.error("err msg : {}", e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
}
