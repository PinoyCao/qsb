package com.ccniit.manager;

import com.ccniit.model.Cylinder;
import com.ccniit.model.response_entity.Data;
import com.ccniit.sys.QueryCylinder;
import com.ccniit.util.RestResult;

public class CylinderDetailManager extends Requester<Cylinder> implements Manageable<Cylinder>{
	private static CylinderDetailManager cylinderdetailmanager=new CylinderDetailManager();
	private CylinderDetailManager(){}
	public static CylinderDetailManager getCylinderDetailManager(){
		return cylinderdetailmanager;
	}
	@Override
	public Data getAll(String size, String page, String sort) {
		return null;
	}

	@Override
	public RestResult<Cylinder> query(String id) {
		return QueryCylinder.querycylinderbyid(id);
	}

	public RestResult<Cylinder> querybyuid(String uid) {
		return QueryCylinder.querycylinderbyuid(uid);
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
