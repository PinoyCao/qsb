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
//管理员编辑自己所属公司
public class EditCurcompany {
	public static RestResult<Company> editcurcompany(Company c){
		// 创建httppost  
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getEDITCURRENT_API());
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	    formparams.add(new BasicNameValuePair("name", c.getName()));   
	    formparams.add(new BasicNameValuePair("phone", c.getPhone())); 
	    formparams.add(new BasicNameValuePair("address", c.getAddress())); 
	    formparams.add(new BasicNameValuePair("remarks", c.getRemarks()));
		RestResult<Company> companyResult = SingleHttpClient.executeForRestResult(httppost,formparams, Company.class);   
		return companyResult;
	}
}
