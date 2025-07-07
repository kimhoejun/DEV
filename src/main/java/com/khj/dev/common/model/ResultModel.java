package com.khj.dev.common.model;

public class ResultModel<T> {
	
	private T data;
	private int status;
	
	public ResultModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultModel(T data, int status) {
		super();
		this.data = data;
		this.status = status;
	}

	
	// getter
	public T getData() { return data; }
	public int getStatus() { return status; }

	
	// setter
	public void setData(T data) { this.data = data; }
	public void setStatus(int status) { this.status = status; }
	
}