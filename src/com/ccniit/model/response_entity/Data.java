package com.ccniit.model.response_entity;

import java.util.List;


public class Data {
	private Boolean result;
	private String message;
	private List<?> content;
	private String totalPages;
	private String totalElements;
	private String last;
	private String numberOfElements;
	private String first;	
	private Sort sort;
	private String size;
	private String number;
	public String getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	public String getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(String totalElements) {
		this.totalElements = totalElements;
	}
	public String isLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(String numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	public String isFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public Sort getSort() {
		return sort;
	}
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public List<?> getContent() {
		return content;
	}
	public void setContent(List<?> content) { 
		this.content = content;
	}
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
