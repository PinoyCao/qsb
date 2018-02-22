package com.ccniit.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
  * <code>UserDataModel</code>类是<code>User</code>的一个数
 * 据封装类。<code>UserDataModel</code>将<code>User</code>
 * 中的数据封装为<code>javafx.scene.control.TableView</code>
 * 可用的数据。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * @see User
 *
 */
public class UserDataModel {
	private User user;
	private StringProperty name;
	private IntegerProperty id;
	private IntegerProperty companyId;//根据权限是否可修改
	private StringProperty loginName;//不可修改
	private StringProperty password;//单独做
	private StringProperty no;//根据权限是否可修改
	private StringProperty email;
	private StringProperty phone;
	private StringProperty mobile;
	private StringProperty photo;	// 头像
	private StringProperty loginIp;	// 最后登陆IP 不可改
	private Date loginDate;	// 最后登陆日期 不可改
	private StringProperty loginFlag;	// 是否允许登陆 根据权限是否可修改
	private StringProperty createBy;//不可改
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;//不可改
	private StringProperty updateBy;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate; //不可改
	private StringProperty remarks;
	private StringProperty delFlag;	//根据权限是否可修改
	public Integer getId() {
		return id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
		user.setId(id);;
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
		user.setName(name);
	}
	
	public Integer getCompanyId() {
		return companyId.get();
	}
	
	public void setCompanyId(Integer companyId) {
		this.companyId.set(companyId);
		user.setCompanyId(companyId);
	}
	
	public String getLoginName() {
		return loginName.get();
	}
	
	public void setLoginName(String loginName) {
		this.loginName.set(loginName);
		user.setLoginName(loginName);
	}
	
	public String getPassword() {
		return password.get();
	}
	
	public void setPassword(String password) {
		this.password.set(password);
		user.setPassword(password);
	}	

	public String getNo() {
		return no.get();
	}
	
	public void setNo(String no) {
		this.no.set(no);
		user.setNo(no);
	}
	
	public String getEmail() {
		return email.get();
	}
	
	public void setEmail(String email) {
		this.email.set(email);
		user.setEmail(email);
	}
	
	public String getPhone() {
		return phone.get();
	}
	
	public void setPhone(String phone) {
		this.phone.set(phone);
		user.setPhone(phone);
	}
	
	public String getMobile() {
		return mobile.get();
	}
	
	public void setMobile(String mobile) {
		this.mobile.set(mobile);
		user.setMobile(mobile);
	}
	
	public String getPhoto() {
		return photo.get();
	}
	
	public void setPhoto(String photo) {
		this.photo.set(photo);
		user.setPhoto(photo);
	}
	
	public String getLoginIp() {
		return loginIp.get();
	}
	
	public void setLoginIp(String loginIp) {
		this.loginIp.set(loginIp);
		user.setLoginIp(loginIp);
	}
	
	public String getLoginFlag() {
		return loginFlag.get();
	}
	
	public void setLoginFlag(String loginFlag) {
		this.loginFlag.set(loginFlag);
		user.setLoginFlag(loginFlag);
	}
	
	public String getCreateBy() {
		return createBy.get();
	}
	
	public void setCreateBy(String createBy) {
		this.createBy.set(createBy);
		user.setCreateBy(createBy);
	}
	
	public String getUpdateBy() {
		return updateBy.get();
	}
	
	public void setUpdateBy(String updateBy) {
		this.updateBy.set(updateBy);
		user.setUpdateBy(updateBy);
	}
	
	public String getRemarks() {
		return remarks.get();
	}
	
	public void setRemarks(String remarks) {
		this.remarks.set(remarks);
		user.setRemarks(remarks);
	}	
	
	public String getDelFlag() {
		return delFlag.get();
	}
	
	public void setDelFlag(String delFlag) {
		this.delFlag.set(delFlag);
		user.setDelFlag(delFlag);
	}
	
	public UserDataModel(User user){
		this.user = user;
		name = new SimpleStringProperty(user.getName());
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public IntegerProperty getCompanyIdProperty() {
		return companyId;
	}

	public StringProperty getLoginNameProperty() {
		return loginName;
	}

	public StringProperty getPasswordProperty() {
		return password;
	}

	public StringProperty getNoProperty() {
		return no;
	}

	public StringProperty getEmailProperty() {
		return email;
	}

	public StringProperty getPhoneProperty() {
		return phone;
	}

	public StringProperty getMobileProperty() {
		return mobile;
	}

	public StringProperty getPhotoProperty() {
		return photo;
	}

	public StringProperty getLoginIpProperty() {
		return loginIp;
	}

	public Date getLoginDateProperty() {
		return loginDate;
	}

	public StringProperty getLoginFlagProperty() {
		return loginFlag;
	}

	public StringProperty getCreateByProperty() {
		return createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public StringProperty getUpdateByProperty() {
		return updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public StringProperty getRemarksProperty() {
		return remarks;
	}

	public StringProperty getDelFlagProperty() {
		return delFlag;
	}


}
