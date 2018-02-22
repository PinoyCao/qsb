/*
 * Validator.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-1.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.util;

/**
 * <code>Validator<code>类提供了数据有效性的验证方法。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.0
 *
 */
public abstract class Validator {
	
	/**
	 * 检测一个字符串是否为double类型
	 * @param str
	 * @return 一个boolean类型
	 */
	public static boolean isDouble(String str){
		boolean bl = false;
		if(str.equals("")){
			return false;
		}
		if(str.startsWith(".")){
			return false;
		}
		if(str.endsWith("f")||str.endsWith("d")){
			return false;
		}
		try{
			Double.parseDouble(str);
			bl = true;
		}catch(Exception e){
			return false;
		}
		return bl;
	}
	
	public abstract boolean validator(String str);

}
