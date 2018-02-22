package com.ccniit.model.response_entity;

public class Compositor {
	private String direction;
	private String property;
	private String ignoreCase;
	private String nullHandling;
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getIgnoreCase() {
		return ignoreCase;
	}
	public void setIgnoreCase(String ignoreCase) {
		this.ignoreCase = ignoreCase;
	}
	public String getNullHandling() {
		return nullHandling;
	}
	public void setNullHandling(String nullHandling) {
		this.nullHandling = nullHandling;
	}
	public String getDescending() {
		return descending;
	}
	public void setDescending(String descending) {
		this.descending = descending;
	}
	public String getAscending() {
		return ascending;
	}
	public void setAscending(String ascending) {
		this.ascending = ascending;
	}
	private String descending;
	private String ascending;
}
