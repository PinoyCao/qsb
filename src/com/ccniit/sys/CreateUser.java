package com.ccniit.sys;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.ccniit.connectServer.Http_util;
import com.ccniit.model.User;
import com.ccniit.util.API;
import com.ccniit.util.RestResult;
import com.ccniit.util.SingleHttpClient;

//创建一个当前用户所属公司的用户
public class CreateUser {
	public static RestResult<User> createuser(User user){
		// 创建httppost  
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getUSERCREATE_API());
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	    formparams.add(new BasicNameValuePair("loginName", user.getLoginName()));
	    formparams.add(new BasicNameValuePair("password", user.getPassword()));	 
	    formparams.add(new BasicNameValuePair("no", user.getNo())); 
	    formparams.add(new BasicNameValuePair("name", user.getName())); 
		if(user.getEmail()!=null)
	    formparams.add(new BasicNameValuePair("email", user.getEmail())); 
		if(user.getPhone()!=null)
	    formparams.add(new BasicNameValuePair("phone", user.getPhone())); 
		if(user.getMobile()!=null)
	    formparams.add(new BasicNameValuePair("mobile", user.getMobile()));
		if(user.getRemarks()!=null)
	    formparams.add(new BasicNameValuePair("remarks", user.getRemarks())); 	 
        RestResult<User> userResult = SingleHttpClient.executeForRestResult(httppost,formparams, User.class);	
		return userResult;
	}
}
