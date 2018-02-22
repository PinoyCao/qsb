package com.ccniit.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Company implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String phone;
	private String address;
	private String companyType;
	private String provinceCode;
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	private String updateBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	private String remarks;
	private String delFlag;
	private String licenseKey;
	private String licenseLevel;
	private static Company company=new Company();
	public static void setCompany(Company c){
		company=c;
	}
	public static Company getCompany(){
		return company;
	}
	public Company() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String proviceCode) {
		this.provinceCode = proviceCode;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	public String getLicenseLevel() {
		return licenseLevel;
	}

	public void setLicenseLevel(String licenseLevel) {
		this.licenseLevel = licenseLevel;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public static boolean isCompanyTypeLegal(String companyType){
		if(companyType.equals("0")||companyType.equals("1")||companyType.equals("2")){
			return true;
		}else return false;
	}




}
