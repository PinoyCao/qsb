/*
 * Transmissibility.java
 * orderDishesSystemServer
 * Created by 冯 友超 on 13-7-5.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.net.common;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
/**
 * <code>TransmissibilityPackage</code>定义了一个包的基本方法。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 * @see Serializable
 * @see Date
 * 
 */
public interface TransmissibilityPackage extends Serializable{
	public String getFrom();
	public String getTo();
	public Date getTime();
	public String getBody();
	public Map<String,Object> getParameters();
	public void setSessionId(String sessionId);
	public String getSessionId();
}
