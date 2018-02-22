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
import com.ccniit.model.Record;
import com.ccniit.model.response_entity.Data;
import com.ccniit.util.API;
import com.ccniit.util.SingleHttpClient;
/**
 * <code>CylinderRecord</code>类是向服务器请求查询气瓶记录的方法类。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 * 
 */

public class CylinderRecord { //在线查看过期气瓶
	static String param="";//传输参数
	/**
	 * 向服务器请求查询气瓶记录的方法
	 * 
	 * @param id 气瓶ID
	 * @param left 开始日期
	 * @param right 结束日期
	 * @return 一个<code>Data</code>对象
	 * 
	 */
	
	public static Data recordall(String id,String left,String right ){
		 Data datainfo=new Data(); 
	     List<NameValuePair> formparams = new ArrayList<NameValuePair>(); 
	     formparams.add(new BasicNameValuePair("id", id));
	     if(left!=null&&!left.equals(""))
	     formparams.add(new BasicNameValuePair("left", left));
	     if(right!=null&&!right.equals(""))
	     formparams.add(new BasicNameValuePair("right", right)); 	  
		 try {
		     //转换为键值对 
		     param= EntityUtils.toString(new UrlEncodedFormEntity(formparams, Consts.UTF_8)); 
			 HttpGet httpget = new HttpGet(Http_util.getURL()+API.getRECORDALL_API()+"?"+param);
	         //执行Get请求，  
			 datainfo = SingleHttpClient.executeForData(httpget,Record.class);  
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return datainfo;
	}
 
} 
