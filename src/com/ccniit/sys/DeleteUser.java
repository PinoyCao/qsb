package com.ccniit.sys;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.ccniit.connectServer.Http_util;
import com.ccniit.util.API;
import com.ccniit.util.RestResult;
import com.ccniit.util.SingleHttpClient;
import com.ccniit.model.User;

public class DeleteUser {
	public static RestResult<User> deleteuser(String id){
        // 创建httppost  
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getUSERDELETE_API());
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	    formparams.add(new BasicNameValuePair("id", id));
		RestResult<User> userResult = SingleHttpClient.executeForRestResult(httppost,formparams, User.class);
		return userResult;
	}
}
