/*
 * TableDataModel.java
 * orderDishesSystem
 * Created by 冯 友超 on 13-7-2.
 * Copyright (c) 2013年 冯 友超. All rights reserved.
 */
package com.ccniit.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * <code>TableDataModel</code>类是<code>Table</code>的一个数
 * 据封装类。<code>TableDataModel</code>将<code>Table</code>
 * 中的数据封装为<code>javafx.scene.control.TableView</code>
 * 可用的数据。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 * @see Table
 * 
 */
public class TableDataModel {

	private Table table;					//所对应的Table对象。
	private StringProperty tableNumber;		//桌号
	
	
	/**
	 * 带有一个<code>Table</code>类型的参数的构造方法。
	 * 此方法可以提取<code>Table</code>中的数据，来初始化
	 * <code>TableDataModel</code>中的数据。
	 * 
	 * @param table 当前<code>TableDataModel</code>对应的<code>Table</code>对象。
	 * @see Table
	 */
	public TableDataModel(Table table) {
		this.table = table;
		tableNumber = new SimpleStringProperty(table.getNumber());
	}

	/**
	 * 获得对应<code>Table</code>对象。
	 * 
	 * @return 对应<code>Table</code>对象。
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * 设置对应的<code>Table</code>对象。
	 * 
	 * @param table 对应的<code>Table</code>对象。
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	
	/**
	 * 获得桌号。
	 * 
	 * @return 桌号。
	 */
	public String getTableNumber() {
		return tableNumber.get();
	}

	
	/**
	 * 设置桌号。
	 * 
	 * @param tableNumber 桌号。
	 */
	public void setTableNumber(String tableNumber) {
		this.tableNumber.set(tableNumber);
//		this.table.setNumber(tableNumber);
	}
	
	
	/**
	 * 获得<code>javafx.beans.property.StringProperty</code>类型的桌号。
	 * 
	 * @return <code>javafx.beans.property.StringProperty</code>类型的桌号。
	 */
	public StringProperty tableNumberProperty(){
		return tableNumber;
	}
	
}
