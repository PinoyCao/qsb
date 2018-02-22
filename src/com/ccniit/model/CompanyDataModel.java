package com.ccniit.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * <code>CompanyDataModel</code>类是<code>Company</code>的一个数
 * 据封装类。<code>CompanyDataModel</code>将<code>Company</code>
 * 中的数据封装为<code>javafx.scene.control.TableView</code>
 * 可用的数据。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see Company
 *
 */
public class CompanyDataModel {
	private Company company;
	private IntegerProperty id;
	private StringProperty companyType;
	private StringProperty name;
	private StringProperty phone;
	private StringProperty address;
	private StringProperty province_code;
	private StringProperty remarks;
	private BooleanProperty	action;
	/**
	 * 一个无参的构造方法。
	 */
	public CompanyDataModel(){}	
	/**
	 * 一个带有一个<code>Company</code>类型的构造方法，
	 * 
	 * @param Company 一个<code>Company</code>对象。
	 * @see Company
	 */
	public CompanyDataModel(Company company){
		this.company=company;
		id=new SimpleIntegerProperty(company.getId());
		companyType=new SimpleStringProperty(company.getCompanyType());
		name=new SimpleStringProperty(company.getName());
		phone=new SimpleStringProperty(company.getPhone());
		address=new SimpleStringProperty(company.getAddress());
		phone=new SimpleStringProperty(company.getPhone());
		province_code=new SimpleStringProperty(company.getProvinceCode());
		remarks=new SimpleStringProperty(company.getRemarks());
	}
	/**
	 * 获得一个<code>Company</code>的对象。
	 * 
	 * @return <code>Company</code>的对象。
	 */
	public  Company getCompany(){
		return company;
	}
	/**
	 * 设置一个<code>Company</code>的对象。
	 * 
	 * @param Company <code>Company</code>的对象。
	 * @see Company
	 */
	public void setCompany(Company company){
		this.company=company;
	}
	public Integer getId() {
		return id.get();
	}
	public String getCompanyType() {
		return companyType.get();
	}
	public String getName(){
		return name.get();
	}
	public String getPhone(){
		return phone.get();
	}
	public String getAddress(){
		return address.get();
	}
	public String getProvince_code(){
		return province_code.get();
	}
	public String getRemarks(){
		return remarks.get();
	}
	
	public void setId(Integer id) {
		this.id.set(id);
	}
	public void setCompanyType(String companyType) {
		this.companyType.set(companyType);
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	public void setAddress(String address) {
		this.address.set(address);
	}
	public void setProvince_code(String province_code) {
		this.province_code.set(province_code);
	}
	public void setRemarks(String remarks) {
		this.remarks.set(remarks);
	}
	public void setAction(boolean action) {
		this.action.set(action);
	}
	
	public IntegerProperty idProperty(){
		return id;
	}
	public StringProperty companyTypeProperty(){
		return companyType;
	}
	public StringProperty addressProperty(){
		return address;
	}
	public StringProperty nameProperty(){
		return name;
	}
	public StringProperty province_codeProperty(){
		return province_code;
	}
	public StringProperty remarksProperty(){
		return remarks;
	}
	public StringProperty phoneProperty(){
		return phone;
	}
	public BooleanProperty actionProperty(){
		return action;
	}
}
