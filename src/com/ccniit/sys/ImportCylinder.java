package com.ccniit.sys;

import java.io.File;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import com.ccniit.connectServer.Http_util;
import com.ccniit.model.Cylinder;
import com.ccniit.util.API;
import com.ccniit.util.RestResult;
import com.ccniit.util.SingleHttpClient;
//以Excel文件形式增加气瓶
public class ImportCylinder {
	public static void importcylinder(File file){
        // 创建httppost  
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getIMPORTCYLINDER_API());
        SingleHttpClient.executeUpFile(httppost,file);
	}
	public static RestResult<Cylinder> lastImport(){
		 HttpGet httpget = new HttpGet(Http_util.getURL()+API.getLASTIMPORT_API());
	     //执行Get请求，  
		 RestResult<Cylinder> datainfo = SingleHttpClient.executeForRole(httpget,Cylinder.class);  
		 return datainfo;
	}
}
