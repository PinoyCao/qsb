package com.ccniit.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * <code>Property_ContentDataModel</code>类是<code>property_content</code>的一个数
 * 据封装类。<code>Property_ContentDataModel</code>将<code>property_content</code>
 * 中的数据封装为<code>javafx.scene.control.TableView</code>
 * 可用的数据。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see property_content
 *
 */
public class Property_ContentDataModel {
	private Property_Content property_content;
	private StringProperty property;
	private StringProperty content;
	public Property_ContentDataModel(Property_Content property_content){
		this.property_content=property_content;
		property = new  SimpleStringProperty(property_content.getProperty());
		content = new SimpleStringProperty(property_content.getContent());
	}
	
	public Property_Content getProperty_Content() {
		return property_content;
	}

	public void setProperty_Content(Property_Content property_content) {
		this.property_content = property_content;
	}
	

	public String getProperty() {
		return property.get();
	}

	public void setProperty(String property) {
		this.property.set(property);
		property_content.setProperty(property);
	}

	public String getContent() {
		return content.get();
	}

	public void setContent(String content) {
		this.content.set(content);
		property_content.setContent(content);
	}
	
}
