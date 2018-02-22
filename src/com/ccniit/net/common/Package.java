/*
 * Package.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-5.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.net.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <code>Package</code>类表示一个包。用于客户端与服务器之间的通讯。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 * @see TransmissibilityPackage
 * 
 */
public abstract class Package implements TransmissibilityPackage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String,Object> parameters = new HashMap<>();	//保存参数的Map
	private final static String REQUEST_KEY  = "request";
	private final static String RESULT_KEY = "result";
	private final static String LOGIN_ID_KEY = "loginId";
	private final static String PASSWORD_KEY = "password";

	private String body;							//用于保存文本信息
	private boolean encript;						//是否加密
	private String from;							//发送者
	private Date time;								//发送时间
	private String to;								//发送对象
	private PackageType type;						//包类型
	private String sessionId;						//会话id

	public Package(){

	}

	public Package(String from,String to){
		this.from = this.to;
	}
	@Override
	public String getBody() {
		return body;
	}
	@Override
	public String getFrom() {
		return from;
	}
	public Object getParameter(String key){
		return parameters.get(key);
	}
	@Override
	public Map<String, Object> getParameters() {
		return parameters;
	}

	public Date getTime() {
		return time;
	}
	@Override
	public String getTo() {
		return to;
	}

	public PackageType getType() {
		return type;
	}

	public boolean isEncript() {
		return encript;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setEncript(boolean encript) {
		this.encript = encript;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public void setPrameter(String key,Object value){
		parameters.put(key, value);
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setType(PackageType type) {
		this.type = type;
	}

	@Override
	public String getSessionId() {
		return sessionId;
	}

	@Override
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getRequest(){
		return (String)getParameter(REQUEST_KEY);
	}

	public Object getResult(){
		return getParameter(RESULT_KEY);
	}

	public String getLoginId(){
		return (String)parameters.get(LOGIN_ID_KEY);
	}

	public String getPassword(){
		return (String)parameters.get(PASSWORD_KEY);
	}

	public void setLoginId(String loginId){
		parameters.put(LOGIN_ID_KEY, loginId);
	}

	public void setPassword(String password){
		parameters.put(PASSWORD_KEY, password);
	}

	public void setRequest(String request){
		parameters.put(REQUEST_KEY, request);
	}

	public void setResult(Object obj){
		parameters.put(RESULT_KEY, obj);
	}

}
