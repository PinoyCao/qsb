package com.ccniit.sys.pub.login;

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

//用户退出
public class UserLogoutcontroller {
	public RestResult<User> controluserlogout(String username,String password){
        // 创建httppost    
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getLOGIN_API());  
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("username", username));  
        formparams.add(new BasicNameValuePair("password", password));  
        System.out.println("executing request " + httppost.getURI());  
        RestResult<User> userResult = SingleHttpClient.executeForRestResult(httppost,formparams, User.class);
        return userResult;
	}

}
