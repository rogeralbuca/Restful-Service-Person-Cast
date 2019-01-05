package br.com.castgroup.model;

public class ResponseModel {
	 
	private String message;
 
	public ResponseModel() {}
 
	public ResponseModel(String message) {
		this.message = message;
	}
 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
 
}
