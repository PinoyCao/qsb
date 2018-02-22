package com.ccniit.sys;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import com.ccniit.model.Company;
import com.ccniit.connectServer.Http_util;
import com.ccniit.util.API;
import com.ccniit.util.RestResult;
import com.ccniit.util.SingleHttpClient;
//删除某个公司，不允许删除当前用户所在公司，且此公司下的所有用户将被禁止登录
public class DeleteCompany {
	public static RestResult<Company> deletecompany(String id){
		// 创建httppost  
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getCOMPANYDELETE_API());
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	    formparams.add(new BasicNameValuePair("id", id));
		RestResult<Company> companyResult = SingleHttpClient.executeForRestResult(httppost,formparams, Company.class);			
		return companyResult;
	}
}
