/*
 * RequestPackage.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-12.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.net.common;


/**
 * <code>RequestPackage</code>类表示一个请求包。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 * @see Package
 *
 */
public class RequestPackage extends Package{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestPackage(String from,String to,String request){
		setType(PackageType.REQUEST);
		setRequest(request);
		setFrom(from);
		setTo(to);
	}
	
	public RequestPackage(String request){
		this(null,null,request);
	}

}
