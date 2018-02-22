package com.ccniit.sys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import com.ccniit.util.API;
import com.ccniit.util.SingleHttpClient;

//把即将过期的气瓶以excel导出
public class WilldueCylinderexcel {
	static String param="";//传输参数
    public static final int cache = 10 * 1024; //根据实际运行效果 设置缓冲区大小 
	public static boolean duecylinderexcel(String day,String filepath){
	    List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		boolean isSucess=false;
	    formparams.add(new BasicNameValuePair("day", day));  
		 try {
			 param= EntityUtils.toString(new UrlEncodedFormEntity(formparams, Consts.UTF_8));
			 HttpGet httpget = new HttpGet(Http_util.getURL()+API.getWILLEXPIRE_EXCEL_API()+"?"+param);
	         InputStream is = SingleHttpClient.execute(httpget).getEntity().getContent(); 
	         File file = new File(filepath);  
	         file.getParentFile().mkdirs();  
	         FileOutputStream fileout = new FileOutputStream(file);  
	         byte[] buffer=new byte[cache];  
	         int ch = 0;  
	         while ((ch = is.read(buffer)) != -1) {  
	               fileout.write(buffer,0,ch);  
	         }  
	         is.close();  
	         fileout.flush();  
	         fileout.close();  
	         isSucess=true;
		 } catch (ClientProtocolException e1) {
				e1.printStackTrace();
		 } catch (IOException e1) {
				e1.printStackTrace();
		}
		 return isSucess;
	}
}
