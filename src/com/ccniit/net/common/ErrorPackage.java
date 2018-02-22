/*
 * ErrorPackage.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-11.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.net.common;


/**
 * <code>ErrorPackage</code>类表示一个错误包。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 * @see Package
 *
 */
public class ErrorPackage extends Package{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErrorPackage(String form,String to,String error){
		setType(PackageType.ERROR);
		setPrameter("error",error );
	}
	
	public ErrorPackage(String error){
		this("","",error);
	}

	@Override
	public String toString() {
		return (String)getParameter("error");
	}

	
}
