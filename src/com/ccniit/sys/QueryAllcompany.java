package com.ccniit.sys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.ccniit.connectServer.Http_util;
import com.ccniit.model.Company;
import com.ccniit.model.response_entity.Data;
import com.ccniit.util.API;
import com.ccniit.util.SingleHttpClient;

public class QueryAllcompany {
	static String param="";//传输参数
	public static Data queryallcompany(String size,String page,String sort){
		 Data datainfo=new Data(); 
	     List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	     formparams.add(new BasicNameValuePair("size", size));  
	     formparams.add(new BasicNameValuePair("page", page));
	     formparams.add(new BasicNameValuePair("sort", sort)); 	  
		 try {
		     //转换为键值对 
		     param= EntityUtils.toString(new UrlEncodedFormEntity(formparams, Consts.UTF_8)); 
			 HttpGet httpget = new HttpGet(Http_util.getURL()+API.getCOMPANYVIEW_API()+"?"+param);
	         //执行Get请求，  
			 datainfo = SingleHttpClient.executeForData(httpget,Company.class);  
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return datainfo;
	}
}
