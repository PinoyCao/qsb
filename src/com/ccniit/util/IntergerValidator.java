/*
 * IntergerValidator.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-4.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.util;

@Deprecated
public class IntergerValidator extends Validator{

	@Override
	public boolean validator(String str) {
		boolean bl = false;
		try{
			Integer.parseInt(str);
			bl = true;
		}catch(Exception e){
			
		}
		return bl;
	}
	
	
}
