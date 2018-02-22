package com.ccniit.sys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.methods.HttpGet;
import com.ccniit.connectServer.Http_util;
import com.ccniit.util.API;
import com.ccniit.util.SingleHttpClient;
/**
 * <code>DueCylinderexcel</code>类是把已经过期的气瓶以excel导出的方法类。
 * 
 * @author caoyan
 * @version 1.0
 * @since JDK7
 *
 */
//
public class DueCylinderexcel {
	String param="";//传输参数
    public static final int cache = 10 * 1024; //根据实际运行效果 设置缓冲区大小 
	/**
	 * 把已经过期的气瓶以excel导出
	 * 
	 * @param filepath excel文件存储路径
	 */
	public static boolean duecylinderexcel(String filepath){ 
		boolean isSucess=false;
		HttpGet httpget = new HttpGet(Http_util.getURL()+API.getEXPIREDCYLINDER_EXCEL_API());
		InputStream is;
		try { 
			 is = SingleHttpClient.execute(httpget).getEntity().getContent();
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
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		} 
		return isSucess;
	}
}
