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
//管理员编辑自己所属公司
public class EditCurpassword {
	public static RestResult<User> editcurcompany(String id,String password){
		// 创建httppost  
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getEDITCUR_API());
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>(); 
	    formparams.add(new BasicNameValuePair("id", id)); 
	    formparams.add(new BasicNameValuePair("password", password));   
		RestResult<User> userResult = SingleHttpClient.executeForRestResult(httppost,formparams, User.class);   
		return userResult;
	}
}
