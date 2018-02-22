/*
 * MD5.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-1.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 *
 */
public class MD5 {

	/**
	 * 对一个byte数组进行MD5加密
	 * @param srcBytes
	 * @return 加密后的byte数组
	 */
	public byte[] encrypt(byte[] srcBytes){
		byte[] resultBytes = null;
		try{
			MessageDigest sha = MessageDigest.getInstance("MD5");
			sha.update(srcBytes);
			resultBytes = sha.digest();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return resultBytes;
	}
	public String MakeString(byte[] bytes){
		StringBuilder stringBuilder = new StringBuilder();
		for(byte b:bytes){
			stringBuilder.append(b);
		}
		return stringBuilder.toString();
	}

}
