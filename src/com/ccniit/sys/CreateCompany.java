package com.ccniit.sys;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.ccniit.connectServer.Http_util;
import com.ccniit.model.Company;
import com.ccniit.util.API;
import com.ccniit.util.RestResult;
import com.ccniit.util.SingleHttpClient;

//创建某个公司，并同时以此公司的公司名为loginName,电话为password创建该公司管理员
public class CreateCompany {
	public  static RestResult<Company> createcompany(Company c){
        // 创建httppost  
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getCOMPANYCREATE_API());
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>();      
	    formparams.add(new BasicNameValuePair("name", c.getName())); 
	    formparams.add(new BasicNameValuePair("phone", c.getPhone())); 
		if(c.getAddress()!=null)
	    formparams.add(new BasicNameValuePair("address", c.getAddress())); 
	    formparams.add(new BasicNameValuePair("companyType", c.getCompanyType()));
	    if(c.getRemarks()!=null)
	    formparams.add(new BasicNameValuePair("remarks", c.getRemarks())); 
	    if(c.getProvinceCode()!=null)
		formparams.add(new BasicNameValuePair("proviceCode", c.getProvinceCode()));	
        RestResult<Company> companyResult = SingleHttpClient.executeForRestResult(httppost,formparams, Company.class);
		return companyResult;
	}
}
