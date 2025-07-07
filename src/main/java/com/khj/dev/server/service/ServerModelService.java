package com.khj.dev.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.khj.dev.common.model.TestModel;

@Service
public class ServerModelService {


	/**
	 * select * from dual
	 * @return models
	 */
	public List<TestModel> getAllModels() {

		List<TestModel> listTestModel = new ArrayList<>();
		
		try {
			
			listTestModel = List.of(
					  new TestModel("202507010001", "223002", new BigDecimal("800000000"), false)
					, new TestModel("202507010002", "223002", new BigDecimal("600000000"), true) 
			);
		} catch(Exception e) {
			e.getMessage();
		}

		return listTestModel;
	}

	
	/**
	 * select * from dual where loanRqsNo = $loanRqsNo
	 * @param loanRqsNo
	 * @return model
	 */
	public TestModel getModel(String loanRqsNo) {

		TestModel resultModel = new TestModel();
		
		try {
			
			List<TestModel> listTestModel = List.of(
					  new TestModel("202507010001", "223002", new BigDecimal("800000000"), false)
					, new TestModel("202507010002", "223002", new BigDecimal("600000000"), true) 
			);

			for(TestModel model : listTestModel) {
				
				if( loanRqsNo.equals(model.getLoanRqsNo()) ) {
					resultModel = model;
				}
			}
		} catch(Exception e) {
			e.getMessage();
		}
		
		return resultModel;
	}
	
}
