package com.ccniit.util;

import java.util.List;

public class RestResult<T> {
	private boolean result;
	private String message;
	private T data;
	private List<T> list;
	public RestResult(boolean result, String message) {
		super();
		this.result = result;
		this.message = message;
	}
	public RestResult(boolean result, String message, T data) {
		super();
		this.result = result;
		this.message = message;
		this.data = data;
	}
	
	public RestResult(boolean result, String message,List<T> list) {
		super();
		this.result = result;
		this.message = message;
		this.list = list;
	}	
	
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
