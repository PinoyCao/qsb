package com.ccniit.manager;

import com.ccniit.model.Cylinder;
import com.ccniit.model.response_entity.Data;
import com.ccniit.sys.OQWDCcontroller;
import com.ccniit.util.RestResult;

public class WillExpireCylinderManager extends Requester<Cylinder> implements Manageable<Cylinder>{
	
	private static WillExpireCylinderManager willexpireCylinderManager=new WillExpireCylinderManager();
	
	private WillExpireCylinderManager(){}
	
	public static WillExpireCylinderManager getWillExpireCylinderManager() {
		return willexpireCylinderManager;
	}

	@Override
	public Data getAll(String size,String page,String sort) {
		return null;
	}
	public Data getAll(String size,String page,String day,String sort) {
		return OQWDCcontroller.contronlOQDC(size, page, day, sort);
	}
	@Override
	public RestResult<Cylinder> query(String id) {
		return null;
	}
	
	@Override
	public RestResult<Cylinder> delete(Cylinder t) {
		return null;
	}

	@Override
	public RestResult<Cylinder> save(Cylinder t) {
		return null;
		
	}

	@Override
	public RestResult<Cylinder> update(Cylinder t) {
		return null;
		
	}
}
