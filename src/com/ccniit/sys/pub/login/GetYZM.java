package com.ccniit.sys.pub.login;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import com.ccniit.connectServer.Http_util;
import com.ccniit.util.SingleHttpClient;



//获取验证码
public class GetYZM {
    public static javafx.scene.image.Image getValidateImage() {  
        InputStream inputStream = null;  
        inputStream = getInputStream();//调用getInputStream()函数。  
        javafx.scene.image.Image image =  new javafx.scene.image.Image(inputStream);
        try{
        	if(inputStream!=null){
        		inputStream.close();
        	}
        }catch(Exception e){
        	return null;
        }
        return image;
    }  
	public static InputStream getInputStream(){
        try {  
            String url = Http_util.getURL()+"validateCodeServlet";//创建的URL  
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = SingleHttpClient.execute(httpGet); 
            return response.getEntity().getContent();
        }catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
}
}