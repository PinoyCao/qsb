/*
 * DoubleValidator.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-4.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.util;


/**
 * <code>DoubleValidator</code>类提供了验证double类型数据的方法。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.0
 */
@Deprecated
public class DoubleValidator extends Validator{

	@Override
	public boolean validator(String str) {
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
			e.printStackTrace();
			return false;
		}
		return bl;
	}
}
