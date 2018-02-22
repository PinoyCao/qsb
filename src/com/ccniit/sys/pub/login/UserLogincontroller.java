package com.ccniit.sys.pub.login;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.ccniit.connectServer.Http_util;
import com.ccniit.model.User;
import com.ccniit.util.API;
import com.ccniit.util.RestResult;
import com.ccniit.util.SingleHttpClient;

//用户登录
public class UserLogincontroller {
	public static RestResult<User> controluserlogin(String username,String password){
		return controluserlogin(username, password, "");
	}
	
	public static RestResult<User> controluserlogin(String username,String password,String YZM){
        // 创建httppost    
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getLOGIN_API());  
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("username", username));  
        formparams.add(new BasicNameValuePair("password", password));  
        formparams.add(new BasicNameValuePair("validateCode", YZM));
        System.out.println("executing request" + httppost.getURI());  
        RestResult<User> userResult = SingleHttpClient.executeForRestResult(httppost,formparams, User.class);
        return userResult;
	}
	@SuppressWarnings("rawtypes")
	public static FutureTask<RestResult> asyncLogin(String username,String password,String YZM){
		 	final HttpPost httppost = new HttpPost(Http_util.getURL()+API.getLOGIN_API());  
		 	//创建线程池  
	        ExecutorService es = Executors.newSingleThreadExecutor();  
		 	
		 	List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	        formparams.add(new BasicNameValuePair("username", username));  
	        formparams.add(new BasicNameValuePair("password", password));  
	        formparams.add(new BasicNameValuePair("validateCode", YZM));
	        System.out.println("executing request" + httppost.getURI());  
	        //RestResult<User> userResult = 
	        FutureTask<RestResult> futureTask = new FutureTask<RestResult>(new Callable<RestResult>() {
				@Override
				public RestResult call() throws Exception {
					return SingleHttpClient.executeForRestResult(httppost,formparams, User.class);
				}
			});
	        //执行任务  
	        es.submit(futureTask);  
	        //关闭线程池  
	        es.shutdown();
	        return futureTask;
	}
	
}
