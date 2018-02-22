package com.ccniit.manager;

import com.ccniit.model.Cylinder;
import com.ccniit.model.response_entity.Data;
import com.ccniit.sys.OQDCcontroller;
import com.ccniit.sys.QueryCylinder;
import com.ccniit.util.RestResult;

public class ExpiredCylinderManager extends Requester<Cylinder> implements Manageable<Cylinder>{
	
	private static ExpiredCylinderManager expiredCylinderManager=new ExpiredCylinderManager();
	
	private ExpiredCylinderManager(){}
	
	public static ExpiredCylinderManager getExpiredCylinderManager() {
		return expiredCylinderManager;
	}

	@Override
	public Data getAll(String size,String page,String sort) {
		return OQDCcontroller.controlOQDC(size,page);
	}

	@Override
	public RestResult<Cylinder> query(String id) {
		return QueryCylinder.querycylinderbyid(id);
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
