package com.ccniit.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * <code>StaffDataModel</code>类是<code>User</code>的一个数
 * 据封装类。<code>StaffDataModel</code>将<code>User</code>
 * 中的数据封装为<code>javafx.scene.control.TableView</code>
 * 可用的数据。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see User
 *
 */
public class StaffDataModel {
	private  User user;
	private IntegerProperty id;
	private IntegerProperty companyId;
	private StringProperty loginName;
	private StringProperty no;
	private StringProperty name;
	private StringProperty email;
	private StringProperty phone;
	private StringProperty mobile;
	private IntegerProperty action;
	/**
	 * 一个无参的构造方法。
	 */
	public StaffDataModel(){}
	/**
	 * 一个带有一个<code>User</code>类型的构造方法，
	 * 
	 * @param User 一个<code>User</code>对象。
	 * @see User
	 */
	public StaffDataModel(User user){
		this.user=user;
		id=new SimpleIntegerProperty(user.getId());
		companyId=new SimpleIntegerProperty(user.getCompanyId());
		loginName=new SimpleStringProperty(user.getLoginName());
		no=new SimpleStringProperty(user.getNo());
		name=new SimpleStringProperty(user.getName());
		email=new SimpleStringProperty(user.getEmail());
		phone=new SimpleStringProperty(user.getPhone());
		mobile=new SimpleStringProperty(user.getMobile());
	}
	/**
	 * 一个带有八个参数的构造方法。
	 * 
	 * 	 
	 */
	public StaffDataModel(int id,int companyId,String loginName,String no,String name,String email,String phone,String mobile){
		this.id = new SimpleIntegerProperty(id);
		this.companyId = new SimpleIntegerProperty(companyId);
		this.loginName = new SimpleStringProperty(loginName);
		this.name = new SimpleStringProperty(name);
		this.no = new SimpleStringProperty(no);
		this.email = new SimpleStringProperty(email);
		this.phone = new SimpleStringProperty(phone);
		this.mobile = new SimpleStringProperty(mobile);
	}
	/**
	 * 获得一个<code>User</code>的对象。
	 * 
	 * @return <code>User</code>的对象。
	 */
	public  User getStaff(){
		return user;
	}
	/**
	 * 设置一个<code>User</code>的对象。
	 * 
	 * @param User <code>User</code>的对象。
	 * @see User
	 */
	public void setStaff(User user){
		this.user=user;
	}
	
	public Integer getId() {
		return id.get();
	}
	public Integer getCompanyId() {
		return companyId.get();
	}
	public String getLoginName() {
		return loginName.get();
	}
	public String getName() {
		return name.get();
	}
	public String getNo() {
		return no.get();
	}
	public String getEmail() {
		return email.get();
	}
	public String getPhone() {
		return phone.get();
	}
	public String getMobile() {
		return mobile.get();
	}
	public Integer getAction() {
		return action.get();
	}
	
	public void setId(Integer id) {
		this.id.set(id);
	}
	public void setCompanyId(Integer companyId) {
		this.companyId.set(companyId);
	}
	public void setLoginName(String loginName) {
		this.loginName.set(loginName);
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public void setNo(String no) {
		this.no.set(no);
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	public void setMobile(String mobile) {
		this.mobile.set(mobile);
	}
	public void setAction(Integer action) {
		this.action.set(action);
	}

	public IntegerProperty idProperty(){
		return id;
	}
	public IntegerProperty companyIdProperty(){
		return companyId;
	}
	public StringProperty loginNameProperty(){
		return loginName;
	}
	public StringProperty nameProperty(){
		return name;
	}
	public StringProperty noProperty(){
		return no;
	}
	public StringProperty emailProperty(){
		return email;
	}
	public StringProperty phoneProperty(){
		return phone;
	}
	public StringProperty mobileProperty(){
		return mobile;
	}
	public IntegerProperty actionProperty(){
		return action;
	}
}
