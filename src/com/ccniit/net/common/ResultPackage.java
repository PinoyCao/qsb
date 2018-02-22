/*
 * ResultPackage.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-11.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.net.common;


/**
 * <code>ResultPackage</code>类表示一个结果包。
 * 用于响应请求包。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 * @see Package
 *
 */
public class ResultPackage extends Package{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResultPackage(String from,String to,Object result){
		setType(PackageType.RESULT);
		setResult(result);
	}
	
	public ResultPackage(Object result){
		this(null,null,result);
	}
}
