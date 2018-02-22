package com.ccniit.connectServer;
import com.ccniit.model.Constant;
public class Http_util {
	private static String url;
	private static String testurl;
	public static String getTesturl() {
		if(Http_util.testurl==null){
			init();
		}
		System.out.println(Http_util.testurl);
		return testurl;
	}
	public static void setTesturl(String testurl) {
		Http_util.testurl = testurl;
	}
	private Http_util(){};
	public static String getURL(){
		if(Http_util.url==null){
			init();
		}
		System.out.println(Http_util.url);
		return Http_util.url;
	}
	public static void  init() {     
		  try{
		      	Http_util.url = Constant.PROTOCOL+"://"+Constant.SERVER_HOST+":"+Constant.SERVER_PORT+"/";
		      	Http_util.testurl = Constant.PROTOCOL+"://"+Constant.SERVER_HOST+":"+Constant.SERVER_PORT+"/"+"login.html";		      				      		
	       }catch(Exception e){
		             System.out.println(e);
		          } 
		      } 
	
	
	  public static void threadstart(Object flag){
		  	LinkThread d=new LinkThread(getTesturl(),flag);
	        d.start();
	  }
}
