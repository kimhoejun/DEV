package com.khj.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khj.dev.model.ResultModel;
import com.khj.dev.model.TestModel;
import com.khj.dev.service.ModelService;

@RestController
@RequestMapping("/api")
public class ModelController {
	
	private static ModelService service;
	
	public ModelController() {
		// TODO Auto-generated constructor stub
		service = new ModelService();
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

}
