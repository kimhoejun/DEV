package com.khj.dev.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khj.dev.common.model.ResultModel;
import com.khj.dev.common.model.TestModel;
import com.khj.dev.server.service.ServerModelService;

@RestController
@RequestMapping("/serverEndpoints")
public class ServerModelController {
	
	private static ServerModelService service;
	
	public ServerModelController() {
		// TODO Auto-generated constructor stub
		service = new ServerModelService();
	}

	
	@GetMapping("/models")
	public ResponseEntity<ResultModel<List<TestModel>>> getAllModels() {
		
		List<TestModel> models = new ArrayList<>();
		
		try {
			
			models = service.getAllModels();
			
		} catch(Exception e) {
			e.getMessage();
		}
	
		return ResponseEntity.ok().body(new ResultModel<>(models, HttpStatus.OK.value()));
	}

	
	@GetMapping("models/{loanRqsNo}")
	public ResponseEntity<ResultModel<TestModel>> getSingleModels(@PathVariable("loanRqsNo") String loanRqsNo) {
		
		TestModel model = new TestModel();
		
		try {
			
			if(service.getModel(loanRqsNo) == null) {
				return ResponseEntity.notFound().build();
			} else {
				model = service.getModel(loanRqsNo);
			}
			
		} catch(Exception e) {
			e.getMessage();
		}
		
		return ResponseEntity.ok().body(new ResultModel<>(model, HttpStatus.OK.value()));
	}
	
	@PostMapping("/models/receive")
	public ResponseEntity<String> receive(@RequestBody TestModel model) {
		
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append("receive data -> [loanRqsNo: ").append(model.getLoanRqsNo()).append(", ")
			.append("custNo:").append(model.getCustNo()).append(", ")
			.append("loanAmt:").append(model.getLoanAmt()).append(", ")
			.append("targetYn:").append(model.getTargetYn()).append("]");;
			
			System.out.println(buffer.toString());
			
		} catch(Exception e) {
			e.getMessage();
		}
		
		return ResponseEntity.ok("Server Receive Succ!!");
	}

}
