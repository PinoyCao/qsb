/*
 * PackageType.java
 * orderDishesSystemServer
 * Created by 冯 友超 on 13-7-5.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.net.common;

/**
 * <code>PackageType</code>枚举定义了包类型。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 */
public enum PackageType {

	MESSAGE(1),LOGIN(2),REQUEST(3),RESULT(4),ERROR(5),LOGOUT(6);
	int id;
	private PackageType(int id){
		this.id = id;
	}
	/**
	 * 获得类型id。
	 * 
	 * @return 类型的id。
	 */
	public int getId(){
		return id;
	}
}
