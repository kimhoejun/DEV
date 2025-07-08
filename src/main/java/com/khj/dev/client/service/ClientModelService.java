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
	
	private static RestTemplate restTemplate;
	private static ObjectMapper objectMapper;
	
	public String jsonToServiceEndpoint() {
		
		String result = "";
		
		try {
		
			// Read json file
			TestModel model = objectMapper.readValue(new ClassPathResource("request.json").getFile(), TestModel.class);
			logger.info(">>>>>> client service model: ", model);
			
			// request header
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			// Header + reqBody
			HttpEntity<TestModel> reqHttpEntity = new HttpEntity<TestModel>(model, headers);
			
			String url = "http://localhost:8080/serverEndpoints/models/receive";
			ResponseEntity<String> response = restTemplate.postForEntity(url, reqHttpEntity, String.class);
			logger.info("<<<<<< client service response: ", response);
			
			result = response.getBody();
			
		} catch(Exception e) {
			logger.error("err msg : {}", e.getMessage());
		}
		
		return result;
	}
}
