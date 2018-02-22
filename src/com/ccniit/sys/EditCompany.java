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

//局方管理员编辑某个公司的信息
public class EditCompany {
	public static RestResult<Company> editcompany(Company c){
		// 创建httppost  
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getCOMPANYEDIT_API());
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	    formparams.add(new BasicNameValuePair("id", c.getId()+"")); 
	    formparams.add(new BasicNameValuePair("name", c.getName()));  
	    formparams.add(new BasicNameValuePair("phone", c.getPhone())); 
	    formparams.add(new BasicNameValuePair("address",c.getAddress())); 
	    formparams.add(new BasicNameValuePair("proviceCode", c.getProvinceCode()));
	    formparams.add(new BasicNameValuePair("remarks", c.getRemarks())); 		    
		RestResult<Company> companyResult = SingleHttpClient.executeForRestResult(httppost,formparams, Company.class);	
		return companyResult;
	}
}
