package com.ccniit.model;

public class Property_Content {
	/**
	 * <code>Property_Content</code>类是<code>Cylinder</code>类的衍生类
	 * 其中以键值对的形式存储<code>Cylinder</code>类的属性名和对应的属性内容
	 * @author caoyan
	 * @version 1.0
	 * @since JDK7
	 *
	 */
	private String property;					//属性名称
	private String content;						//内容
	public Property_Content(String property,String content){
		this.property=property;
		this.content=content;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	
}
