/*
 * RequestDataHelper.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-12.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.manager;

import java.util.List;

/**
 * <code>RequestDataHelper</code>定义了获得数据的方法。
 * 这个类方法涉及到连接服务器。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 *
 * @param <E> 请求数据的类型
 */
public interface RequestDataHelper<E> {
	
	/**
	 * 根据一个请求字段，获得某个类型的<code>java.util.List</code>集合。
	 * 
	 * @param request 请求字段。
	 * @return 某个类型的<code>java.util.List</code>集合。
	 */
	public List<E> requestData(String request);
	
	
	/**
	 * 更新数据。
	 * 
	 * @param request 请求字段
	 * @param key 附加对象的key
	 * @param value 附加对象
	 * @return 状态字符串
	 */
	public String updateData(String request,String key,E value);
	
}
