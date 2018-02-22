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

//修改当前用户信息
public class AlterCurrentUser {
	static String param="";//传输参数
	public static RestResult<User>  alterUser(User user){
		 HttpPost httppost = new HttpPost(Http_util.getURL()+API.getALTER_API());
	     List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	     formparams.add(new BasicNameValuePair("id", user.getId()+""));  
	     formparams.add(new BasicNameValuePair("name", user.getName())); 
	     formparams.add(new BasicNameValuePair("email", user.getEmail())); 
	     formparams.add(new BasicNameValuePair("phone", user.getPhone())); 
	     formparams.add(new BasicNameValuePair("mobile", user.getMobile())); 
	     formparams.add(new BasicNameValuePair("photo", user.getPhoto())); 
	     formparams.add(new BasicNameValuePair("updateBy", user.getUpdateBy())); 
	     formparams.add(new BasicNameValuePair("remarks", user.getRemarks())); 	  
	     RestResult<User>    userResult = SingleHttpClient.executeForRestResult(httppost,formparams, User.class);
		 return userResult;
	}
}
