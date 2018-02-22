/*
 * LoginPackage.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-9.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.net.common;


/**
 * <code>LoginPackage</code>类表示一个登录包。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 * @see Package
 *
 */
public class LoginPackage extends Package{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginPackage(String loginId,String password){
		this(null, null, loginId, password);
	}
	
	public LoginPackage(String from,String to,String loginId,String password){
		setFrom(from);
		setTo(to);
		setLoginId(loginId);
		setPassword(password);
		setType(PackageType.LOGIN);
	}

}
