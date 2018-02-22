package com.ccniit.sys;


import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import com.ccniit.connectServer.Http_util;
import com.ccniit.model.Cylinder;
import com.ccniit.util.API;
import com.ccniit.util.RestResult;
import com.ccniit.util.SingleHttpClient;



public class AddCylinder{
	public static RestResult<Cylinder> addcylinder(Cylinder c){
        // 创建httppost  
        HttpPost httppost = new HttpPost(Http_util.getURL()+API.getADDCYLINDER_API());
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("id", c.getId()));  
        formparams.add(new BasicNameValuePair("uid", c.getUid()));
        formparams.add(new BasicNameValuePair("companyId", c.getCompanyId())); 
        formparams.add(new BasicNameValuePair("type", c.getType()));
        formparams.add(new BasicNameValuePair("volume", c.getVolume()+""));
        
        formparams.add(new BasicNameValuePair("testCycle", c.getTestCycle()));
        formparams.add(new BasicNameValuePair("workingPressure", c.getWorkingPressure()));  
        formparams.add(new BasicNameValuePair("manufactureDate", c.getManufactureDate()));  
        formparams.add(new BasicNameValuePair("productionUnitCode", c.getProductionUnitCode()));  
        
        formparams.add(new BasicNameValuePair("lastInspectionFlag", c.getLastInspectionFlag()));   
        formparams.add(new BasicNameValuePair("state", c.getState()));  
        formparams.add(new BasicNameValuePair("model", c.getModel()));  
        formparams.add(new BasicNameValuePair("waterOverpressure", c.getWaterOverpressure()));
        
        formparams.add(new BasicNameValuePair("material", c.getMaterial()));  
        formparams.add(new BasicNameValuePair("contentName", c.getContentName()));  
        formparams.add(new BasicNameValuePair("manufacturingNumber", c.getManufacturingNumber()));  
        formparams.add(new BasicNameValuePair("serviceLife", c.getServiceLife()));  
        formparams.add(new BasicNameValuePair("location", c.getLocation())); 
        RestResult<Cylinder> cylinderResult = SingleHttpClient.executeForRestResult(httppost,formparams, Cylinder.class);
		return cylinderResult;
	}
}
