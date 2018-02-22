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
import com.ccniit.model.Cylinder;
import com.ccniit.model.response_entity.Data;
import com.ccniit.util.API;
import com.ccniit.util.SingleHttpClient;
/**
 * <code>OQDCcontroller</code>类是向服务器请求查询已经过期气瓶的方法类。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * 
 */

public class OQDCcontroller { //在线查看过期气瓶
	static String param="";//传输参数
	/**
	 * 向服务器请求查询已经过期气瓶的方法
	 * 
	 * @param size 页面大小
	 * @param page 页数，从0开始
	 * @return 一个<code>Data</code>对象
	 * 
	 */
	
	public static Data controlOQDC(String size,String page){
		 Data datainfo=new Data(); 
	     List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
	     formparams.add(new BasicNameValuePair("size", size));  
	     formparams.add(new BasicNameValuePair("page", page));	  
		 try {
		     //转换为键值对 
		     param= EntityUtils.toString(new UrlEncodedFormEntity(formparams, Consts.UTF_8)); 
			 HttpGet httpget = new HttpGet(Http_util.getURL()+API.getEXPIREDCYLINDER_ONLINE_API()+"?"+param);
	         //执行Get请求，  
			 datainfo = SingleHttpClient.executeForData(httpget,Cylinder.class);  
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return datainfo;
	}
 
} 
