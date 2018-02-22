package com.ccniit.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RecordDataModel {
	private Record record;
	private LongProperty id;
	private StringProperty cylinderId;
	private IntegerProperty userId;
	private IntegerProperty companyId;
	private StringProperty operation;
	private StringProperty operationNumber;
	private StringProperty description;
	private StringProperty date;
	/**
	 * 一个无参的构造方法。
	 */
	public RecordDataModel(){}
	/**
	 * 一个带有一个<code>User</code>类型的构造方法，
	 * 
	 * @param User 一个<code>User</code>对象。
	 * @see User
	 */
	public RecordDataModel(Record record){
		this.record=record;
		id=new SimpleLongProperty(record.getId());
		cylinderId=new SimpleStringProperty(record.getCylinderId());
		userId=new SimpleIntegerProperty(record.getUserId());
		companyId=new SimpleIntegerProperty(record.getCompanyId());
		operation=new SimpleStringProperty(record.getOperation());
		operationNumber=new SimpleStringProperty(record.getOperationNumber());
		description=new SimpleStringProperty(record.getDescription());
		date=new SimpleStringProperty(record.getDate());
	}
	
	public RecordDataModel(Long id,String cylinderId,Integer userId,Integer companyId,String operation,String operationNumber,String description,String date){
		this.id = new SimpleLongProperty(id);
		this.cylinderId = new SimpleStringProperty(cylinderId);
		this.userId = new SimpleIntegerProperty(userId);
		this.companyId = new SimpleIntegerProperty(companyId);
		this.operation = new SimpleStringProperty(operation);
		this.operationNumber = new SimpleStringProperty(operationNumber);
		this.description = new SimpleStringProperty(description);
		this.date=new SimpleStringProperty(date);
	}
	
	/**
	 * 获得一个<code>Record</code>的对象。
	 * 
	 * @return <code>Record</code>的对象。
	 */
	public Record getRecord(){
		return record;
	}
	/**
	 * 设置一个<code>Record</code>的对象。
	 * 
	 * @param record <code>Record</code>的对象。
	 * @see Record
	 */
	public void setRecord(Record record){
		this.record=record;
	}
	
	public Long getId() {
		return id.get();
	}
	public Integer getCompanyId() {
		return companyId.get();
	}
	public String getCylinderId() {
		return cylinderId.get();
	}
	public Integer getUserId() {
		return userId.get();
	}
	public String getOperation() {
		return operation.get();
	}
	public String getOperationNumber() {
		return operationNumber.get();
	}
	public String getDescription() {
		return description.get();
	}
	public String getDate() {
		return date.get();
	}
	
	public void setId(Integer id) {
		this.id.set(id);
	}
	public void setCompanyId(Integer companyId) {
		this.companyId.set(companyId);
	}
	public void setCylinderId(String cylinderId) {
		this.cylinderId.set(cylinderId);
	}
	public void setUserId(Integer userId) {
		this.userId.set(userId);
	}
	public void setOperation(String operation) {
		this.operation.set(operation);
	}
	public void setOperationNumber(String operationNumber) {
		this.operationNumber.set(operationNumber);
	}
	public void setDescription(String description) {
		this.description.set(description);
	}
	public void setDate(String date) {
		this.date.set(date);
	}
	
	public LongProperty idProperty(){
		return id;
	}
	public IntegerProperty companyIdProperty(){
		return companyId;
	}
	public StringProperty cylinderIdProperty(){
		return cylinderId;
	}
	public IntegerProperty userIdProperty(){
		return userId;
	}
	public StringProperty operationProperty(){
		return operation;
	}
	public StringProperty operationNumberProperty(){
		return operationNumber;
	}
	public StringProperty descriptionProperty(){
		return description;
	}
	public StringProperty dateProperty(){
		return date;
	}
	

}
