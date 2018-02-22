package com.ccniit.sys;

import org.apache.http.client.methods.HttpGet;

import com.ccniit.connectServer.Http_util;
import com.ccniit.util.API;
import com.ccniit.util.RestResult;
import com.ccniit.util.SingleHttpClient;
import com.ccniit.model.Company;

public class QueryCurcompany {
	//返回当前用户所属公司
	public  static RestResult<Company> querycurcompamy(){ 
		 HttpGet httpget = new HttpGet(Http_util.getURL()+API.getCURRENTCOMPANY_API());
         RestResult<Company> companyResult = SingleHttpClient.executeForRestResult(httpget, Company.class);
		 return companyResult;
	}
}
