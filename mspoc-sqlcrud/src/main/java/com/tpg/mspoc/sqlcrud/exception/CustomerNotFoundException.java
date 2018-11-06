package com.tpg.mspoc.sqlcrud.exception;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException() {
	}
	
	public CustomerNotFoundException(String msg) {
		this.msg = msg;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
