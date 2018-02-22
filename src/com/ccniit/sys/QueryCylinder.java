package com.ccniit.sys;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import com.ccniit.util.RestResult;
import com.ccniit.util.SingleHttpClient;
import com.ccniit.connectServer.Http_util;
import com.ccniit.model.Cylinder;
import com.ccniit.util.API;


public class QueryCylinder{
 public static RestResult<Cylinder> querycylinderbyid(String id){
 	 HttpPost httppost = new HttpPost(Http_util.getURL()+API.getCYLINDERDETAIL_API());
     List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
     formparams.add(new BasicNameValuePair("id", id));  
	 RestResult<Cylinder> cylinderResult = SingleHttpClient.executeForRestResult(httppost,formparams, Cylinder.class);
	 return cylinderResult;
 }
 
 
 public static RestResult<Cylinder> querycylinderbyuid(String uid){
 	 HttpPost httppost = new HttpPost(Http_util.getURL()+API.getCYLINDERDETAIL_API());
     List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
     formparams.add(new BasicNameValuePair("uid", uid));  
	 RestResult<Cylinder> cylinderResult = SingleHttpClient.executeForRestResult(httppost,formparams, Cylinder.class);
	 return cylinderResult;
}
 
}