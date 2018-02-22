/*
 * Table.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-6-27.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.model;

import java.io.Serializable;


/**
 * <code>Table</code>类，表示一个桌子，它映射数据库中的
 * Tables表。
 * @author fengyouchao
 * @version 1.0
 * @since JDK1.5
 *
 */
public class Table implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;					//主键
	private String number;			//桌号
	private boolean onUsing;		//是否正在适用
	private boolean hide;			//是否隐藏
	
	
	/**
	 * 获得id号。
	 * 
	 * @return id号。
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 设置id号。
	 * 
	 * @param id id号。
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 获得编号。
	 * 
	 * @return 编号。
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * 设置编号。
	 * 
	 * @param number 编号。
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * 判断是否正在使用。
	 * 
	 * @return 如果正在使用,返回<tt>true</tt>。
	 */
	public boolean isOnUsing() {
		return onUsing;
	}
	
	/**
	 * 设置使用状态。
	 * 
	 * @param onUsing <tt>true</tt>表示设置为正在使用。
	 */
	public void setOnUsing(boolean onUsing) {
		this.onUsing = onUsing;
	}
	
	
	/**
	 * 判断是否隐藏。
	 * 
	 * @return 如果隐藏，则返回<tt>true</tt>。
	 */
	public boolean isHide() {
		return hide;
	}
	
	/**
	 * 设置隐藏属性。
	 * 
	 * @param hide <tt>true</tt>表示设置为隐藏。
	 */
	public void setHide(boolean hide) {
		this.hide = hide;
	}
	
	@Override
	public String toString() {
		return number;
	}

}
