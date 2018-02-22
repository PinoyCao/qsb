/*
 * LogoutPackage.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-12.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.net.common;


/**
 * <code>LogoutPackage</code>类表示一个注销包。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 * @see Package
 *
 */
public class LogoutPackage extends Package{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LogoutPackage(){
		
		setType(PackageType.LOGOUT);
	}
	
}
