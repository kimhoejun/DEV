package com.khj.dev.model;

import java.math.BigDecimal;

public class TestModel {
	
	private String loanRqsNo;
	private String custNo;
	private BigDecimal loanAmt;
	private Boolean targetYn;
	
	public TestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TestModel(String loanRqsNo, String custNo, BigDecimal loanAmt, Boolean targetYn) {
		super();
		this.loanRqsNo = loanRqsNo;
		this.custNo = custNo;
		this.loanAmt = loanAmt;
		this.targetYn = targetYn;
	}

	
	// getter
	public String getLoanRqsNo() { return loanRqsNo; }
	public String getCustNo() { return custNo; }
	public BigDecimal getLoanAmt() { return loanAmt; }
	public Boolean getTargetYn() { return targetYn; }
	
	
	// setter
	public void setLoanRqsNo(String loanRqsNo) { this.loanRqsNo = loanRqsNo; }
	public void setCustNo(String custNo) { this.custNo = custNo; }
	public void setLoanAmt(BigDecimal loanAmt) { this.loanAmt = loanAmt; }
	public void setTargetYn(Boolean targetYn) { this.targetYn = targetYn; }
	
}
