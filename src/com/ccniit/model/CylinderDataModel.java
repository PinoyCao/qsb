package com.ccniit.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * <code>CylinderDataModel</code>类是<code>Cylinder</code>的一个数
 * 据封装类。<code>CylinderDataModel</code>将<code>Cylinder</code>
 * 中的数据封装为<code>javafx.scene.control.TableView</code>
 * 可用的数据。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see Cylinder
 *
 */
public class CylinderDataModel {
	private Cylinder cylinder;		//对应的Deal对象。
	//following fields are used for TableView
	private  StringProperty id;
	private  StringProperty uid;
	private  StringProperty companyId;
	private  StringProperty state;
	private  StringProperty name;
	private  StringProperty type;
	private  StringProperty contentName;
	private  StringProperty testCycle;
	private  StringProperty serviceLife;
	private  StringProperty location;
	private  StringProperty manufactureDate;
	/**
	 * 一个无参的构造方法。
	 */
	public CylinderDataModel(){};
	/**
	 * 一个带有一个<code>Cylinder</code>类型的构造方法，
	 * 
	 * @param cylinder 一个<code>Cylinder</code>对象。
	 * @see Cylinder
	 */
	public CylinderDataModel(Cylinder cylinder){
		this(cylinder.getId(),cylinder.getUid(),cylinder.getCompanyId(),cylinder.getState(),cylinder.getName(),cylinder.getType(),cylinder.getContentName(),cylinder.getTestCycle(),cylinder.getServiceLife(),cylinder.getLocation(),cylinder.getManufactureDate());
		this.cylinder = cylinder;
	}
	/**
	 * 一个带有十一个参数的构造方法。
	 * 
	 * 	 
	 */
	public CylinderDataModel(String id, String uid,String companyId, String state, String name, String type,
			String contentName, String testCycle, String serviceLife, String location,String manufactureDate) {
		this.id = new SimpleStringProperty(id);
		this.uid = new SimpleStringProperty(uid);
		this.companyId = new SimpleStringProperty(companyId);
		this.state = new SimpleStringProperty(state);
		this.name = new SimpleStringProperty(name);
		this.type = new SimpleStringProperty(type);
		this.contentName = new SimpleStringProperty(contentName);
		this.testCycle = new SimpleStringProperty(testCycle);
		this.serviceLife = new SimpleStringProperty(serviceLife);
		this.location = new SimpleStringProperty(location);
		this.manufactureDate = new SimpleStringProperty(manufactureDate);
	}
	
	
	
	/**
	 * 获得一个<code>Cylinder</code>的对象。
	 * 
	 * @return <code>Cylinder</code>的对象。
	 */
	public Cylinder getCylinder() {
		return cylinder;
	}
	
	/**
	 * 设置一个<code>Cylinder</code>的对象。
	 * 
	 * @param cylinder <code>Cylinder</code>的对象。
	 * @see Cylinder
	 */
	public void setCylinder(Cylinder cylinder) {
		this.cylinder = cylinder;
	}
	
	public String getId() {
		return id.get();
	}
	public String getUid() {
		return uid.get();
	}
	public String getCompanyId() {
		return companyId.get();
	}
	public String getState() {
		return state.get();
	}
	public String getName() {
		return name.get();
	}
	public String getType() {
		return type.get();
	}
	public String getContentName() {
		return contentName.get();
	}
	public String getTestCycle() {
		return testCycle.get();
	}
	public String getServiceLife() {
		return serviceLife.get();
	}
	public String getLocation() {
		return location.get();
	}
	public String getManufactureDate() {
		return manufactureDate.get();
	}
	
	public void setId(String id) {
		this.id.set(id);
	}
	public void setUid(String uid) {
		this.uid.set(uid);
	}
	public void setCompanyId(String companyId) {
		this.companyId.set(companyId);
	}
	public void setState(String state) {
		this.state.set(state);
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public void setType(String type) {
		this.type.set(type);
	}
	public void setContentName(String contentName) {
		this.contentName.set(contentName);
	}
	public void setTestCycle(String testCycle) {
		this.testCycle.set(testCycle);
	}
	public void setServiceLife(String serviceLife) {
		this.serviceLife.set(serviceLife);
	}
	public void setLocation(String location) {
		this.location.set(location);
	}
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate.set(manufactureDate);
	}
	
	public StringProperty idProperty(){
		return id;
	}
	public StringProperty uidProperty(){
		return uid;
	}
	public StringProperty CompanyIdProperty(){
		return companyId;
	}
	public StringProperty stateProperty(){
		return state;
	}
	public StringProperty nameProperty(){
		return name;
	}
	public StringProperty typeProperty(){
		return type;
	}
	public StringProperty contentNameProperty(){
		return contentName;
	}
	public StringProperty testCycleProperty(){
		return testCycle;
	}
	public StringProperty serviceLifeProperty(){
		return serviceLife;
	}
	public StringProperty locationProperty(){
		return location;
	}
	public StringProperty manufactureDateProperty(){
		return manufactureDate;
	}	
}
